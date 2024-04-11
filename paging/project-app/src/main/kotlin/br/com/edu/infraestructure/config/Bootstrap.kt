package br.com.edu.infraestructure.config

import br.com.edu.domain.model.*
import br.com.edu.domain.repository.ProjectRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class Bootstrap (
    private val repository: ProjectRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {

        val versions = List(2) {index -> ProjectVersion(UUID.randomUUID(), index.toString(), Documentation("Doc-$index", DocType.MARKDOWN)) }
            .toSet()

        val parameters = List(2) { index -> ProjectParameter("Param$index", "Value$index") }.toSet()

        for (i in 1..2) {
            val id = UUID.randomUUID()
            repository.save(
                Project(
                    "Project $id",
                    "Description $id",
                    User(id = UUID.randomUUID(), name = "user $id", username = "user_name_$id"),
                    versions,
                    parameters
                )
            )
        }
    }
}