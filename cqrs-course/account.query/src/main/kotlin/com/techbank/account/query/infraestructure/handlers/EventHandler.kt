package com.techbank.account.query.infraestructure.handlers

import com.techbank.account.common.events.AccountClosedEvent
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.account.common.events.FundsDepositedEvent
import com.techbank.account.common.events.FundsWithdrawnEvent


interface EventHandler {
    fun on(event: AccountOpenedEvent)
    fun on(event: FundsDepositedEvent)
    fun on(event: FundsWithdrawnEvent)
    fun on(event: AccountClosedEvent)
}
