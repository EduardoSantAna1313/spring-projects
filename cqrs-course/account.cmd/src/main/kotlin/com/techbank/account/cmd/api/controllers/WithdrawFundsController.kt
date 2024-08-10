package com.techbank.account.cmd.api.controllers

import com.techbank.account.cmd.api.commands.WithdrawFundsCommand
import com.techbank.account.common.dto.BaseResponse
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException
import com.techbank.cqrs.core.infraestructure.CommandDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.logging.Level
import java.util.logging.Logger

@RestController
@RequestMapping(path = ["/api/v1/withdrawFunds"])
class WithdrawFundsController {
    private val logger: Logger = Logger.getLogger(
        WithdrawFundsController::class.java.name
    )

    @Autowired
    private lateinit var commandDispatcher: CommandDispatcher

    @PutMapping(path = ["/{id}"])
    fun withdrawFunds(
        @PathVariable(value = "id") id: UUID,
        @RequestBody command: WithdrawFundsCommand
    ): ResponseEntity<BaseResponse> {
        try {
            command.id = id
            commandDispatcher.send(command)
            return ResponseEntity(
                BaseResponse("Withdraw funds request completed successfully!"),
                HttpStatus.OK
            )
        } catch (e: IllegalStateException) {
            logger.warning("Client made a bad request - $e.")
            return ResponseEntity(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: AggregateNotFoundException) {
            logger.warning("Client made a bad request - $e.")
            return ResponseEntity(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: Exception) {
            val safeErrorMessage = "Error while processing request to withdraw funds from bank account with id - $id."
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(
                BaseResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}
