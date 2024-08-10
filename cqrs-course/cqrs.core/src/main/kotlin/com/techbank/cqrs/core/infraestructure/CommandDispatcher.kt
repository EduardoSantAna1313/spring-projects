package com.techbank.cqrs.core.infraestructure

import com.techbank.cqrs.core.command.BaseCommand
import com.techbank.cqrs.core.command.CommandHandlerMethod

interface CommandDispatcher {

    fun <T: BaseCommand> registerHandler(type: Class<T>, handler: CommandHandlerMethod<T>)

    fun send(command: BaseCommand)
}