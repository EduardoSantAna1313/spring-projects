package com.techbank.cqrs.core.domain

import com.techbank.cqrs.core.event.BaseEvent
import java.text.MessageFormat
import java.util.UUID
import java.util.logging.Level
import java.util.logging.Logger

abstract class AggregateRoot {
    var id: UUID = UUID.randomUUID()
        protected set
    var version: Int = -1

    private val changes: MutableList<BaseEvent> = ArrayList()
    private val logger: Logger = Logger.getLogger(
        AggregateRoot::class.java.name
    )

    val uncommittedChanges: List<BaseEvent>
        get() = this.changes

    fun markChangesAsCommitted() {
        changes.clear()
    }

    private fun applyChange(event: BaseEvent, isNewEvent: Boolean) {
        try {
            val method = javaClass.getDeclaredMethod("apply", event::class.java)
            method.isAccessible = true
            method.invoke(this, event)
        } catch (e: NoSuchMethodException) {
            logger.log(
                Level.WARNING,
                MessageFormat.format(
                    "The apply method was not found in the aggregate for {0}",
                    event::class.java.getName()
                )
            )
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Error applying event to aggregate", e)
        } finally {
            if (isNewEvent) {
                changes.add(event)
            }
        }
    }

    fun raiseEvent(event: BaseEvent) {
        applyChange(event, true)
    }

    fun replayEvents(events: List<BaseEvent?>) {
        events.forEach {
            if (it != null)
                applyChange(it, false)
        }
    }
}