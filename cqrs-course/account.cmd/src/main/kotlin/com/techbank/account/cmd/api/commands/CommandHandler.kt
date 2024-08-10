package com.techbank.account.cmd.api.commands


interface CommandHandler {
    fun handle(command: OpenAccountCommand)
    fun handle(command: DepositFundsCommand)
    fun handle(command: WithdrawFundsCommand)
    fun handle(command: CloseAccountCommand)
}
