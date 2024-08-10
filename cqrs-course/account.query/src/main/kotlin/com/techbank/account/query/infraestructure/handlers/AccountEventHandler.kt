package com.techbank.account.query.infraestructure.handlers

import com.techbank.account.common.events.AccountClosedEvent
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.account.common.events.FundsDepositedEvent
import com.techbank.account.common.events.FundsWithdrawnEvent
import com.techbank.account.query.domain.AccountRepository
import com.techbank.account.query.domain.BankAccount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse


@Service
class AccountEventHandler : EventHandler {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    override fun on(event: AccountOpenedEvent) {


        val bankAccount = BankAccount(event.id,
            event.accountHolder,
            event.createdDate,
            event.accountType,
            event.openingBalance)
        accountRepository.save<BankAccount>(bankAccount)
    }

    override fun on(event: FundsDepositedEvent) {
        val bankAccount = accountRepository.findById(event.id).getOrElse { return }

        val currentBalance = bankAccount.balance
        val latestBalance = currentBalance.plus(event.amount)
        bankAccount.balance = latestBalance
        accountRepository.save(bankAccount)
    }

    override fun on(event: FundsWithdrawnEvent) {
        val bankAccount = accountRepository.findById(event.id).getOrElse {
            return
        }

        val currentBalance = bankAccount.balance
        val latestBalance = currentBalance - event.amount
        accountRepository.save(bankAccount)
    }

    override fun on(event: AccountClosedEvent) {
        accountRepository.deleteById(event.id)
    }
}
