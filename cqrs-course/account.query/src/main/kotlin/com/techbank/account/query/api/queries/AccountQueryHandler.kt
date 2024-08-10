package com.techbank.account.query.api.queries

import com.techbank.account.query.api.dto.EqualityType
import com.techbank.account.query.domain.AccountRepository
import com.techbank.account.query.domain.BankAccount
import com.techbank.cqrs.core.domain.BaseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Consumer


@Service
class AccountQueryHandler : QueryHandler {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    override fun handle(query: FindAllAccountsQuery): List<BaseEntity> {
        val bankAccounts = accountRepository.findAll()
        val bankAccountsList: MutableList<BaseEntity> = ArrayList()
        bankAccounts.forEach(Consumer { e: BankAccount ->
            bankAccountsList.add(
                e
            )
        })
        return bankAccountsList
    }

    override fun handle(query: FindAccountByIdQuery): List<BaseEntity> {
        val bankAccount = accountRepository.findById(query.id)
        if (bankAccount.isEmpty) {
            return listOf()
        }
        val bankAccountList: MutableList<BaseEntity> = ArrayList()
        bankAccountList.add(bankAccount.get())
        return bankAccountList
    }

    override fun handle(query: FindAccountByHolderQuery): List<BaseEntity> {
        val bankAccount =
            accountRepository.findByAccountHolder(query.accountHolder)
        if (bankAccount.isEmpty) {
            return listOf()
        }
        val bankAccountList: MutableList<BaseEntity> = ArrayList()
        bankAccountList.add(bankAccount.get())
        return bankAccountList
    }

    override fun handle(query: FindAccountWithBalanceQuery): List<BaseEntity> {
        val bankAccountsList =
            if (query.equalityType === EqualityType.GREATER_THAN
            ) accountRepository.findByBalanceGreaterThan(query.balance)
            else accountRepository.findByBalanceLessThan(query.balance)
        return bankAccountsList
    }
}
