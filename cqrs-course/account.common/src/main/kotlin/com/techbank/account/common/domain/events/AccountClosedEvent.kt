package com.techbank.account.common.domain.events

import com.techbank.cqrs.core.event.BaseEvent
import java.util.UUID

class AccountClosedEvent(
    id: UUID,
    version: Int
):
    BaseEvent(id, version) {
}