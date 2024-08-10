package com.techbank.account.query.domain

import com.techbank.cqrs.core.domain.BaseEntity
import org.springframework.data.repository.CrudRepository
import java.math.BigDecimal
import java.util.*


interface AccountRepository : CrudRepository<BankAccount, UUID> {
    fun findByAccountHolder(accountHolder: String?): Optional<BankAccount>

    fun findByBalanceGreaterThan(balance: BigDecimal): List<BaseEntity>

    fun findByBalanceLessThan(balance: BigDecimal): List<BaseEntity>
}
