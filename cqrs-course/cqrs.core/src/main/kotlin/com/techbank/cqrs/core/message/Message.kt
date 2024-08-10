package com.techbank.cqrs.core.message

import java.util.UUID

abstract  class Message (
    open val id: UUID
)