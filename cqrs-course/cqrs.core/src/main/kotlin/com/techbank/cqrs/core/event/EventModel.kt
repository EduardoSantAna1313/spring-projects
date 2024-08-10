package com.techbank.cqrs.core.event

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "eventStore")
class EventModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val timeStamp: LocalDateTime = LocalDateTime.now(),

    val aggregateIdentifier: UUID? = null,

    val aggregateType: String? = null,

    val version: Int = 0,

    val eventType: String? = null,

    val eventData: BaseEvent? = null
) {

    class Builder {
        private var id: UUID = UUID.randomUUID()
        private var timeStamp: LocalDateTime = LocalDateTime.now()
        private var aggregateIdentifier: UUID? = null
        private var aggregateType: String? = null
        private var version: Int = 0
        private var eventType: String? = null
        private var eventData: BaseEvent? = null

        fun id(id: UUID) = apply { this.id = id }
        fun timeStamp(timeStamp: LocalDateTime) = apply { this.timeStamp = timeStamp }
        fun aggregateIdentifier(aggregateIdentifier: UUID) = apply { this.aggregateIdentifier = aggregateIdentifier }
        fun aggregateType(aggregateType: String) = apply { this.aggregateType = aggregateType }
        fun version(version: Int) = apply { this.version = version }
        fun eventType(eventType: String) = apply { this.eventType = eventType }
        fun eventData(eventData: BaseEvent) = apply { this.eventData = eventData }

        fun build() = EventModel(id,  timeStamp, aggregateIdentifier, aggregateType, version, eventType, eventData)
    }
}
