package com.techbank.account.query.infraestructure

import com.techbank.cqrs.core.domain.BaseEntity
import com.techbank.cqrs.core.infraestructure.QueryDispatcher
import com.techbank.cqrs.core.queries.BaseQuery
import com.techbank.cqrs.core.queries.QueryHandlerMethod
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountQueryDispatcher : QueryDispatcher {

    private val routes: MutableMap<Class<out BaseQuery>, MutableList<QueryHandlerMethod<*>>> = HashMap()

    override fun <T : BaseQuery> registerHandler(
        type: Class<T>,
        handler: QueryHandlerMethod<T>
    ) {
        val handlers = routes.computeIfAbsent(type) { _: Class<out BaseQuery> -> LinkedList() }
        handlers.add(handler)
    }

    override fun <U : BaseEntity> send(query: BaseQuery): List<BaseQuery> {
        val handlers: List<QueryHandlerMethod<*>>? = routes[query.javaClass]
        if (handlers.isNullOrEmpty()) {
            throw RuntimeException("No query handler was registered!")
        }
        if (handlers.size > 1) {
            throw RuntimeException("Cannot send query to more than one handler!")
        }
        return handlers[0].handle(query)
    }
}
