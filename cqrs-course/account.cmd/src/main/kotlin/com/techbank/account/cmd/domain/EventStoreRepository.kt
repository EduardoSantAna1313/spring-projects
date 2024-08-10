package com.techbank.account.cmd.domain

import com.techbank.cqrs.core.event.EventModel
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*


interface EventStoreRepository: MongoRepository<EventModel, UUID> {

    fun findByAggregateIdentifier(aggregateIdentifier: UUID): List<EventModel>

}