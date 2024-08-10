package com.techbank.account.query.api.queries

import com.techbank.cqrs.core.queries.BaseQuery
import java.util.UUID

class FindAccountByIdQuery(
    val id: UUID
) : BaseQuery()