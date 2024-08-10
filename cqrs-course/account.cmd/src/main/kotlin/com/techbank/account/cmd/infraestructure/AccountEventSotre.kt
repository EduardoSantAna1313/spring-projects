package com.techbank.account.cmd.infraestructure

import com.techbank.account.cmd.domain.AccountAggregate
import com.techbank.account.cmd.domain.EventStoreRepository
import com.techbank.cqrs.core.EventProducer
import com.techbank.cqrs.core.event.BaseEvent
import com.techbank.cqrs.core.event.EventModel
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException
import com.techbank.cqrs.core.exceptions.ConcurrencyException
import com.techbank.cqrs.core.infraestructure.EventStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountEventStore : EventStore {

    @Autowired
    private lateinit var eventProducer: EventProducer

    @Autowired
    private lateinit var eventStoreRepository: EventStoreRepository

    override fun saveEvents(
        aggregateId: UUID,
        events: List<BaseEvent>,
        expectedVersion: Int ) {

        val eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId)
        if (expectedVersion != -1 && eventStream[eventStream.size - 1].version != expectedVersion) {
            throw ConcurrencyException()
        }
        var version = expectedVersion

        events.forEach { event ->
            version++
            event.version = version
            val eventModel: EventModel = EventModel.Builder()
                .aggregateIdentifier(aggregateId)
                .aggregateType(AccountAggregate::class.java.typeName)
                .version(version)
                .eventType(event.javaClass.typeName)
                .eventData(event)
                .build()
            val persistedEvent = eventStoreRepository.save<EventModel>(eventModel)
            eventProducer.produce(event::class.java.simpleName, event)
        }
    }

    override fun getEvents(aggregateId: UUID): List<BaseEvent?> {
        val eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId)
        if (eventStream.isEmpty()) {
            throw AggregateNotFoundException("Incorrect account ID provided!")
        }
        return eventStream.map { it.eventData }
    }
}
