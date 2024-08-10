package com.techbank.account.cmd.api.commands

import com.techbank.cqrs.core.command.BaseCommand
import java.util.UUID

class CloseAccountCommand(
    override val id: UUID
) : BaseCommand(id) {
}
