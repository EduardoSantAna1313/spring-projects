package com.techbank.cqrs.core.exceptions

class AggregateNotFoundException(
    override val message: String
) : RuntimeException(message)
