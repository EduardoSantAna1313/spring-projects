package com.techbank.account.query.domain

import com.techbank.account.common.domain.models.AccountType
import com.techbank.cqrs.core.domain.BaseEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class BankAccount (

    @Id
    val id: UUID = UUID.randomUUID(),
    val accountHolder: String? = null,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val accountType: AccountType? = null,
    var balance : BigDecimal = BigDecimal.ZERO

) : BaseEntity()

