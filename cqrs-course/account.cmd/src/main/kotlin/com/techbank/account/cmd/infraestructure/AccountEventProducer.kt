package com.techbank.account.cmd.infraestructure

import com.techbank.cqrs.core.EventProducer
import com.techbank.cqrs.core.event.BaseEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class AccountEventProducer : EventProducer {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, Any>
    override fun produce(topic: String, event: BaseEvent) {
        kafkaTemplate.send(topic, event)
    }
}
