package com.techbank.account.cmd.api.controllers

import com.techbank.account.cmd.api.commands.DepositFundsCommand
import com.techbank.account.common.dto.BaseResponse
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException
import com.techbank.cqrs.core.infraestructure.CommandDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.logging.Logger

@RestController
@RequestMapping(path = ["/api/v1/depositFunds"])
class DepositFundsController {

    private val logger: Logger = Logger.getLogger(DepositFundsController::class.java.name)

    @Autowired
    private lateinit var commandDispatcher: CommandDispatcher

    @PutMapping(path = ["/{id}"])
    fun depositFunds(
        @PathVariable(value = "id", required = true) id: UUID,
        @RequestBody command: DepositFundsCommand
    ): ResponseEntity<BaseResponse> {
        try {
            command.id = id
            commandDispatcher.send(command)
            return ResponseEntity(
                BaseResponse("Deposit funds request completed successfully!"),
                HttpStatus.OK
            )
        } catch (e: IllegalStateException) {
            logger.warning("Client made a bad request - ${e}.")
            return ResponseEntity(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: AggregateNotFoundException) {
            logger.warning("Client made a bad request - ${e}.")

            return ResponseEntity(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: Exception) {
            val safeErrorMessage = "Error while processing request to deposit funds to bank account with id - ${id}."
            logger.severe(safeErrorMessage)
            return ResponseEntity(
                BaseResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}
