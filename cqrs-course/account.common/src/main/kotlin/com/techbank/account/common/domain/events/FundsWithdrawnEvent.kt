package com.techbank.account.common.domain.events

import com.techbank.cqrs.core.event.BaseEvent
import java.math.BigDecimal
import java.util.UUID

class FundsWithdrawnEvent(
    id: UUID,
    version: Int,
    val amount: BigDecimal
) : BaseEvent(id, version)
