package com.techbank.account.query.api.controllers

import com.techbank.account.query.api.dto.AccountLookupResponse
import com.techbank.account.query.api.dto.EqualityType
import com.techbank.account.query.api.queries.FindAccountByHolderQuery
import com.techbank.account.query.api.queries.FindAccountByIdQuery
import com.techbank.account.query.api.queries.FindAccountWithBalanceQuery
import com.techbank.account.query.api.queries.FindAllAccountsQuery
import com.techbank.account.query.domain.BankAccount
import com.techbank.cqrs.core.infraestructure.QueryDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.UUID
import java.util.logging.Level
import java.util.logging.Logger

@RestController
@RequestMapping(path = ["/api/v1/bankAccountLookup"])
class AccountLookupController {

    private val logger: Logger = Logger.getLogger(AccountLookupController::class.java.name)

    @Autowired
    private lateinit var queryDispatcher: QueryDispatcher

    @GetMapping(path = ["/"])
    fun allAccounts(): ResponseEntity<Any> {
        try {
            val accounts: List<BankAccount> = queryDispatcher.send<BankAccount>(FindAllAccountsQuery()).ifEmpty {
                return ResponseEntity(null, HttpStatus.NO_CONTENT)
            }

            val response = AccountLookupResponse(
                accounts = accounts,
                message ="Successfully returned ${accounts.size} bank account(s)!"
            )
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val safeErrorMessage =
                "Failed to complete get all accounts request!"
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(
                AccountLookupResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @GetMapping(path = ["/byId/{id}"])
    fun getAccountById(@PathVariable(value = "id", required = true) id: UUID): ResponseEntity<Any> {
        try {
            val accounts= queryDispatcher.send<BankAccount>(FindAccountByIdQuery(id)).ifEmpty {
                return ResponseEntity(null, HttpStatus.NO_CONTENT)
            }

            val response = AccountLookupResponse(
                accounts = accounts,
                message = "Successfully returned bank account!"
            )
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val safeErrorMessage = "Failed to complete get accounts by ID request!"
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(
                AccountLookupResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @GetMapping(path = ["/byHolder/{accountHolder}"])
    fun getAccountByHolder(@PathVariable(value = "accountHolder", required = true) accountHolder: String): ResponseEntity<Any> {
        try {
            val accounts = queryDispatcher.send<BankAccount>(FindAccountByHolderQuery(accountHolder)).ifEmpty {
                return ResponseEntity(null, HttpStatus.NO_CONTENT)
            }

            val response = AccountLookupResponse(
                accounts = accounts,
                message = "Successfully returned bank account!"
            )
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val safeErrorMessage = "Failed to complete get accounts by holder request!"
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(
                AccountLookupResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @GetMapping(path = ["/withBalance/{equalityType}/{balance}"])
    fun getAccountWithBalance(
        @PathVariable(value = "equalityType", required = true) equalityType: EqualityType,
        @PathVariable(value = "balance", required = true) balance: BigDecimal
    ): ResponseEntity<AccountLookupResponse> {
        try {
            val accounts = queryDispatcher.send<BankAccount>(FindAccountWithBalanceQuery(equalityType, balance)).ifEmpty {
                return ResponseEntity(null, HttpStatus.NO_CONTENT)
            }

            val response = AccountLookupResponse(
                accounts = accounts,
                message = "Successfully returned ${accounts.size} bank account(s)!"
            )
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val safeErrorMessage =
                "Failed to complete get accounts with balance request!"
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(
                AccountLookupResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}
