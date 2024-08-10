package com.techbank.account.cmd.api.controllers

import com.techbank.account.cmd.api.commands.OpenAccountCommand
import com.techbank.account.cmd.api.dto.OpenAccountResponse
import com.techbank.account.common.dto.BaseResponse
import com.techbank.cqrs.core.infraestructure.CommandDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

@RestController
@RequestMapping(path = ["/api/v1/openBankAccount"])
class OpenAccountController {

    private val logger: Logger = Logger.getLogger(
        OpenAccountController::class.java.name
    )

    @Autowired
    private lateinit var commandDispatcher: CommandDispatcher

    @PostMapping
    fun openAccount(@RequestBody command: OpenAccountCommand): ResponseEntity<BaseResponse> {
        val id = UUID.randomUUID()
        command.id = id
        try {
            commandDispatcher.send(command)
            return ResponseEntity(
                OpenAccountResponse(
                    "Bank account creation request completed successfully!",
                    id
                ), HttpStatus.CREATED
            )
        } catch (e: IllegalStateException) {
            logger.warning("Client made a bad request - ${e}."
            )
            return ResponseEntity(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: Exception) {
            val safeErrorMessage = "Error while processing request to open a new bank account for id - #${id}."
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(
                OpenAccountResponse(safeErrorMessage, id),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}
