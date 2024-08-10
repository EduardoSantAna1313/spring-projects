package com.techbank.account.query.infraestructure.consumers

import com.techbank.account.common.events.AccountClosedEvent
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.account.common.events.FundsDepositedEvent
import com.techbank.account.common.events.FundsWithdrawnEvent
import com.techbank.account.query.infraestructure.handlers.EventHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class AccountEventConsumer : EventConsumer {

    @Autowired
    private lateinit var eventHandler: EventHandler

    @KafkaListener(
        topics = ["AccountOpenedEvent"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    override fun consume(@Payload event: AccountOpenedEvent, ack: Acknowledgment) {
        eventHandler.on(event)
        ack.acknowledge()
    }

    @KafkaListener(
        topics = ["FundsDepositedEvent"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    override fun consume(@Payload event: FundsDepositedEvent, ack: Acknowledgment) {
        eventHandler.on(event)
        ack.acknowledge()
    }

    @KafkaListener(
        topics = ["FundsWithdrawnEvent"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    override fun consume(@Payload event: FundsWithdrawnEvent, ack: Acknowledgment) {
        eventHandler.on(event)
        ack.acknowledge()
    }

    @KafkaListener(
        topics = ["AccountClosedEvent"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    override fun consume(@Payload event: AccountClosedEvent, ack: Acknowledgment) {
        eventHandler.on(event)
        ack.acknowledge()
    }
}
