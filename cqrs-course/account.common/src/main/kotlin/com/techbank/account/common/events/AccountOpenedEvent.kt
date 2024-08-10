package com.techbank.account.common.events

import com.techbank.account.common.domain.models.AccountType
import com.techbank.cqrs.core.event.BaseEvent
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


class AccountOpenedEvent(
    override val id: UUID = UUID.randomUUID(),
    override var version: Int,
    val accountHolder: String? = null,
    val accountType: AccountType? = null,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val openingBalance: BigDecimal = BigDecimal.ZERO
) : BaseEvent(id, version)