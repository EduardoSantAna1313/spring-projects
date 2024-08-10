package com.techbank.account.query.api.queries


import com.techbank.cqrs.core.queries.BaseQuery

class FindAccountByHolderQuery(
    val accountHolder: String
) : BaseQuery()
