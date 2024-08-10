package com.techbank.account.common.events

import com.techbank.cqrs.core.event.BaseEvent
import java.math.BigDecimal
import java.util.*

class FundsWithdrawnEvent(
    override val id: UUID = UUID.randomUUID(),
    override var version: Int,
    val amount: BigDecimal = BigDecimal.ZERO
) : BaseEvent(id, version)
