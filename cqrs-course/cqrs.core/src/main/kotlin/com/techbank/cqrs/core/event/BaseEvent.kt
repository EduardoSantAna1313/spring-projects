package com.techbank.cqrs.core.event

import com.techbank.cqrs.core.message.Message
import java.util.UUID

open class BaseEvent(
    override val id: UUID,
    open var version: Int
): Message(id)