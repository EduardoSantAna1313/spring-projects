package com.techbank.account.cmd.api.commands

import com.techbank.account.common.domain.models.AccountType
import com.techbank.cqrs.core.command.BaseCommand
import java.math.BigDecimal
import java.util.*

class OpenAccountCommand(
    override var id: UUID = UUID.randomUUID(),
    val accountHolder: String,
    val accountType: AccountType,
    val openingBalance: BigDecimal
) : BaseCommand(id) {
}

