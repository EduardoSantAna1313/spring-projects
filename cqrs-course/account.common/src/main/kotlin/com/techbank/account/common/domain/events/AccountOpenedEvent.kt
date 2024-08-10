package com.techbank.account.common.domain.events

import com.techbank.account.common.domain.models.AccountType
import com.techbank.cqrs.core.event.BaseEvent
import java.math.BigDecimal
import java.time.LocalDateTime

class AccountOpenedEvent(
    id: String,
    version: String,
    val accountHolder: String,
    val accountType: AccountType,
    val createdDate: LocalDateTime,
    val openingBalance: BigDecimal
): BaseEvent(id, version) {

    class Builder() {
        var id: String = ""
            private set

        var version: String = "1.0.0"
            private set
        var accountHolder: String = ""
            private set

        var accountType: AccountType = AccountType.CURRENT
            private set
        var createdDate: LocalDateTime = LocalDateTime.now()
            private set

        var openingBalance: BigDecimal = BigDecimal.ZERO
            private set

        fun id(id: String) = apply { this.id = id }

        fun version(version: String) = apply { this.version = version }
        fun accountHolder(accountHolder: String) = apply { this.accountHolder = accountHolder }
        fun accountType(accountType: AccountType) = apply { this.accountType = accountType }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun openingBalance(openingBalance: BigDecimal) = apply { this.openingBalance = openingBalance }


        fun build() = AccountOpenedEvent(
            id, version, accountHolder, accountType, createdDate, openingBalance
        )
    }

}