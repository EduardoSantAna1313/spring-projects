package br.com.edu.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Project (
    val id: UUID,
    val name: String,
    val description: String,
    val createdBy: User,
    val createdAt: LocalDateTime,
    var executionId: UUID?,
    val versions: Set<ProjectVersion>,
    val parameters: Set<ProjectParameter>
) {

    constructor(name: String, description: String, createdBy: User, versions: Set<ProjectVersion>, parameters: Set<ProjectParameter>):
            this(UUID.randomUUID(), name, description, createdBy, LocalDateTime.now(), null, versions, parameters)

}