package com.techbank.account.query.api.queries

import com.techbank.cqrs.core.domain.BaseEntity


interface QueryHandler {
    fun handle(query: FindAllAccountsQuery): List<BaseEntity>
    fun handle(query: FindAccountByIdQuery): List<BaseEntity>
    fun handle(query: FindAccountByHolderQuery): List<BaseEntity>
    fun handle(query: FindAccountWithBalanceQuery): List<BaseEntity>
}