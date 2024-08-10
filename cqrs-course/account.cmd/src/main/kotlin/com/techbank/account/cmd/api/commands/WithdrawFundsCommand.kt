package com.techbank.account.cmd.api.commands

import com.techbank.cqrs.core.command.BaseCommand
import java.math.BigDecimal
import java.util.UUID

class WithdrawFundsCommand(
    override var id: UUID,
    val amount: BigDecimal) : BaseCommand(id) {
}