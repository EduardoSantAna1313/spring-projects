package com.techbank.account.cmd


import com.techbank.account.cmd.api.commands.*
import com.techbank.cqrs.core.infraestructure.CommandDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class CommandApplication {
    @Autowired
    private lateinit var commandDispatcher: CommandDispatcher


    @Autowired
    private lateinit var commandHandler: CommandHandler

    @PostConstruct
    fun registerHandlers() {
        commandDispatcher.registerHandler(
            OpenAccountCommand::class.java,
            commandHandler::handle
        )
        commandDispatcher.registerHandler(
            DepositFundsCommand::class.java,
            commandHandler::handle
        )
        commandDispatcher.registerHandler(
            WithdrawFundsCommand::class.java,
            commandHandler::handle
        )
        commandDispatcher.registerHandler(
            CloseAccountCommand::class.java,
            commandHandler::handle
        )
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CommandApplication::class.java, *args)
        }
    }
}
