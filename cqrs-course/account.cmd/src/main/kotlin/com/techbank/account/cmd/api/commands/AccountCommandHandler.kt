package com.techbank.account.cmd.api.commands

import com.techbank.account.cmd.domain.AccountAggregate
import com.techbank.cqrs.core.handler.EventSourcingHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountCommandHandler : CommandHandler {

    @Autowired
    private lateinit var eventSourcingHandler: EventSourcingHandler<AccountAggregate>

    override fun handle(command: OpenAccountCommand) {
        val aggregate = AccountAggregate(command)
        eventSourcingHandler.save(aggregate)
    }

    override fun handle(command: DepositFundsCommand) {
        val aggregate = eventSourcingHandler.getById(command.id)
        aggregate.depositFunds(command.amount)
        eventSourcingHandler.save(aggregate)
    }

    override fun handle(command: WithdrawFundsCommand) {
        val aggregate = eventSourcingHandler.getById(command.id)
        check(command.amount <= aggregate.balance) { "Withdrawal declined, insufficient funds!" }
        aggregate.withdrawFunds(command.amount)
        eventSourcingHandler.save(aggregate)
    }

    override fun handle(command: CloseAccountCommand) {
        val aggregate = eventSourcingHandler.getById(command.id)
        aggregate.closeAccount()
        eventSourcingHandler.save((aggregate))
    }
}
