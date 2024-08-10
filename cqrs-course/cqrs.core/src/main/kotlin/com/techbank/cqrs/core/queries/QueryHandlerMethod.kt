package com.techbank.cqrs.core.queries


fun interface QueryHandlerMethod<T : BaseQuery> {

    fun handle(query: BaseQuery): List<T>

}