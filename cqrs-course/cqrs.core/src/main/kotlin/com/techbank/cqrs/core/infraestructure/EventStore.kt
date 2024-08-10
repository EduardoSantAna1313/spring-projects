package com.techbank.cqrs.core.infraestructure

import com.techbank.cqrs.core.event.BaseEvent
import java.util.UUID

interface EventStore {
    fun saveEvents(
        aggregateId: UUID,
        events: List<BaseEvent>,
        expectedVersion: Int
    )

    fun getEvents(aggregateId: UUID): List<BaseEvent?>
}
