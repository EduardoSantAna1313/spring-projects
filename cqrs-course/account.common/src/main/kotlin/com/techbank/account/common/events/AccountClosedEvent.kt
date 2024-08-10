package com.techbank.account.common.events

import com.techbank.cqrs.core.event.BaseEvent
import java.util.*

class AccountClosedEvent(id: UUID, version: Int) : BaseEvent(id, version)
