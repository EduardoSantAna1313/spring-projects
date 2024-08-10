package com.techbank.cqrs.core.command

import com.techbank.cqrs.core.message.Message
import java.util.UUID

abstract class BaseCommand(
    override val id: UUID
) : Message(id)