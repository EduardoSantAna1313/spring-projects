package com.techbank.account.cmd.api.controllers


import com.techbank.account.cmd.api.commands.CloseAccountCommand
import com.techbank.account.common.dto.BaseResponse
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException
import com.techbank.cqrs.core.infraestructure.CommandDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.MessageFormat
import java.util.UUID
import java.util.logging.Level
import java.util.logging.Logger

@RestController
@RequestMapping(path = ["/api/v1/closeBankAccount"])
class CloseAccountController {
    private val logger: Logger = Logger.getLogger(
        CloseAccountCommand::class.java.getName()
    )

    @Autowired
    private lateinit var commandDispatcher: CommandDispatcher

    @DeleteMapping(path = ["/{id}"])
    fun closeAccount(@PathVariable(value = "id", required = true) id: UUID): ResponseEntity<BaseResponse> {
        try {
            commandDispatcher.send(CloseAccountCommand(id))
            return ResponseEntity<BaseResponse>(
                BaseResponse("Bank account closure request successfully completed!"),
                HttpStatus.OK
            )
        } catch (e: IllegalStateException) {
            logger.log(
                Level.WARNING,
                MessageFormat.format(
                    "Client made a bad request - {0}.",
                    e.toString()
                )
            )
            return ResponseEntity<BaseResponse>(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: AggregateNotFoundException) {
            logger.log(
                Level.WARNING,
                MessageFormat.format(
                    "Client made a bad request - {0}.",
                    e.toString()
                )
            )
            return ResponseEntity<BaseResponse>(
                BaseResponse(e.toString()),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: Exception) {
            val safeErrorMessage = MessageFormat.format(
                "Error while processing request to close bank account with id - {0}.",
                id
            )
            logger.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity<BaseResponse>(
                BaseResponse(safeErrorMessage),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}
