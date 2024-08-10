package com.techbank.account.cmd.infraestructure

import com.techbank.cqrs.core.command.BaseCommand
import com.techbank.cqrs.core.command.CommandHandlerMethod
import com.techbank.cqrs.core.infraestructure.CommandDispatcher
import org.springframework.stereotype.Service
import java.util.HashMap

@Service
class AccountCommandDispatcher : CommandDispatcher {

    val cache = HashMap<Class<*>, List<CommandHandlerMethod<BaseCommand>>>()

    override fun <T : BaseCommand> registerHandler(type: Class<T>, handler: CommandHandlerMethod<T>
    ) {
        val list = cache.computeIfAbsent(type) { mutableListOf() }
        list.addFirst(handler)
    }

    override fun send(command: BaseCommand) {
        val handlers = cache[command.javaClass]
        if (handlers.isNullOrEmpty()) {
            throw RuntimeException("There's no handler for ${command.javaClass}")
        }

        if (handlers.size > 1) {
            throw RuntimeException("There's multiple handlers for ${command.javaClass}")
        }

        handlers[0].handle(command)
    }
}