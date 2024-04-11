package br.com.edu.api.v1.request

import br.com.edu.domain.model.Project
import br.com.edu.domain.model.ProjectParameter
import br.com.edu.domain.model.ProjectVersion
import br.com.edu.domain.model.User

class ProjectRequest(

    val name: String,

    private val description: String,

    private val versions: Set<ProjectVersion>?,

    private val parameters: Set<ProjectParameter>?
) {
    fun toModel(createdBy: User): Project {
        return Project(name, description, createdBy, versions ?: setOf(),parameters ?: setOf())
    }
}