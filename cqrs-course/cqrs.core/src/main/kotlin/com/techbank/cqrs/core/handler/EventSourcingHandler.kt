package com.techbank.cqrs.core.handler

import com.techbank.cqrs.core.domain.AggregateRoot
import java.util.UUID


interface EventSourcingHandler<T> {
    fun save(aggregate: AggregateRoot)
    fun getById(id: UUID): T
}
