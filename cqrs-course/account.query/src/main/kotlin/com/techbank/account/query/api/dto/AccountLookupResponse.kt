package com.techbank.account.query.api.dto

import com.techbank.account.common.dto.BaseResponse
import com.techbank.account.query.domain.BankAccount

class AccountLookupResponse(
    override val message: String,
    val accounts: List<BankAccount> = ArrayList()
) : BaseResponse(message)