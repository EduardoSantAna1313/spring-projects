package com.techbank.account.query.infraestructure.consumers

import com.techbank.account.common.events.AccountClosedEvent
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.account.common.events.FundsDepositedEvent
import com.techbank.account.common.events.FundsWithdrawnEvent
import org.springframework.kafka.support.Acknowledgment
import org.springframework.messaging.handler.annotation.Payload


interface EventConsumer {
    fun consume(@Payload event: AccountOpenedEvent, ack: Acknowledgment)
    fun consume(@Payload event: FundsDepositedEvent, ack: Acknowledgment)
    fun consume(@Payload event: FundsWithdrawnEvent, ack: Acknowledgment)
    fun consume(@Payload event: AccountClosedEvent, ack: Acknowledgment)
}
