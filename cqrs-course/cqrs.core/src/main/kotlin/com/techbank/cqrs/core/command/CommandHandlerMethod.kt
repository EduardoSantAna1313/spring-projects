package com.techbank.cqrs.core.command

fun interface CommandHandlerMethod<out T: BaseCommand> {

    fun handle(command: @UnsafeVariance T)

}