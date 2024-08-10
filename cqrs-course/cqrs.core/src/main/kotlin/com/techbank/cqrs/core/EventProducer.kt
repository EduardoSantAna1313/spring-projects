package com.techbank.cqrs.core

import com.techbank.cqrs.core.event.BaseEvent

fun interface EventProducer {

    fun produce(topic: String, event: BaseEvent)
}
