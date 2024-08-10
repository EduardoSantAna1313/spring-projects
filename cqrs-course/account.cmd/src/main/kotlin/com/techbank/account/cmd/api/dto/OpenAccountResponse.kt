package com.techbank.account.cmd.api.dto


import com.techbank.account.common.dto.BaseResponse
import java.util.UUID

class OpenAccountResponse(message: String, val id: UUID) :
    BaseResponse(message)
