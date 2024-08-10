package com.techbank.account.cmd.domain


import com.techbank.account.cmd.api.commands.OpenAccountCommand
import com.techbank.account.common.domain.events.AccountClosedEvent
import com.techbank.account.common.domain.events.AccountOpenedEvent
import com.techbank.account.common.domain.events.FundsDepositedEvent
import com.techbank.account.common.domain.events.FundsWithdrawnEvent
import com.techbank.cqrs.core.domain.AggregateRoot
import java.math.BigDecimal

class AccountAggregate(
    private val command: OpenAccountCommand? = null
) : AggregateRoot() {
    private var active: Boolean = true
    var balance = BigDecimal.ZERO

    init {
        command?.let {
            raiseEvent(
                AccountOpenedEvent.Builder()
                    .id(command.id)
                    .accountHolder(command.accountHolder)
                    .accountType(command.accountType)
                    .openingBalance(command.openingBalance)
                    .build()
            )
        }
    }

    fun apply(event: AccountOpenedEvent) {
        this.id = event.id
        this.active = true
        this.balance = event.openingBalance
    }

    fun depositFunds(amount: BigDecimal) {
        check(active) { "Funds cannot be deposited into a closed account!" }
        check(amount <= BigDecimal.ZERO) { "The deposit amount must be greater than 0!" }
        raiseEvent(
            FundsDepositedEvent(this.id, this.version, amount)
        )
    }

    fun apply(event: FundsDepositedEvent) {
        this.id = event.id
        this.balance += event.amount
    }

    fun withdrawFunds(amount: BigDecimal) {
        check(active) { "Funds cannot be withdrawn from a closed account!" }
        raiseEvent(
            FundsWithdrawnEvent(this.id, this.version, amount)
        )
    }

    fun apply(event: FundsWithdrawnEvent) {
        this.id = event.id
        this.balance -= event.amount
    }

    fun closeAccount() {
        check(active) { "The bank account has already been closed!" }
        raiseEvent(
            AccountClosedEvent(this.id, this.version)
        )
    }

    fun apply(event: AccountClosedEvent) {
        this.id = event.id
        this.active = false
    }
}
