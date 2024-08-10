package com.techbank.cqrs.core.infraestructure

import com.techbank.cqrs.core.domain.BaseEntity
import com.techbank.cqrs.core.queries.BaseQuery
import com.techbank.cqrs.core.queries.QueryHandlerMethod

interface QueryDispatcher {
    fun <T : BaseQuery> registerHandler(
        type: Class<T>,
        handler: QueryHandlerMethod<T>
    )

    fun <U : BaseEntity> send(query: BaseQuery): List<U>
}
