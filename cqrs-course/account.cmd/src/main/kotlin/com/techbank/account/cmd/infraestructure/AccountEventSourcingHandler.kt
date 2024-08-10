package com.techbank.account.cmd.infraestructure

import com.techbank.account.cmd.domain.AccountAggregate
import com.techbank.cqrs.core.domain.AggregateRoot
import com.techbank.cqrs.core.handler.EventSourcingHandler
import com.techbank.cqrs.core.infraestructure.EventStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AccountEventSourcingHandler : EventSourcingHandler<AccountAggregate?> {

    @Autowired
    private lateinit var eventStore: EventStore

    override fun save(aggregate: AggregateRoot) {
        eventStore.saveEvents(
            aggregate.id,
            aggregate.uncommittedChanges,
            aggregate.version
        )
        aggregate.markChangesAsCommitted()
    }

    override fun getById(id: UUID): AccountAggregate {
        val aggregate = AccountAggregate()
        val events = eventStore.getEvents(id)
        if (events.isNotEmpty()) {
            aggregate.replayEvents(events)
            val latestVersion = events.maxOf { it!!.version }
            aggregate.version = latestVersion
        }
        return aggregate
    }
}
