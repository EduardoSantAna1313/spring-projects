package com.techbank.account.cmd.api.commands

import com.techbank.cqrs.core.command.BaseCommand
import java.math.BigDecimal
import java.util.*

class DepositFundsCommand(
    override var id: UUID,
    val amount: BigDecimal
) : BaseCommand(id)