package com.techbank.account.query.api.queries

import com.techbank.account.query.api.dto.EqualityType
import com.techbank.cqrs.core.queries.BaseQuery
import java.math.BigDecimal

class FindAccountWithBalanceQuery(
    val equalityType: EqualityType,
    val balance: BigDecimal = BigDecimal.ZERO
) : BaseQuery() {
}