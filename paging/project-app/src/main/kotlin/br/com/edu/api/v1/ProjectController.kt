package br.com.edu.api.v1

import br.com.edu.api.v1.request.ProjectRequest
import br.com.edu.application.ProjectService
import br.com.edu.domain.model.Project
import br.com.edu.domain.model.User
import br.com.edu.domain.repository.ProjectRepository
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.domain.Pageable
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.RepresentationModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*


@RestController
@RequestMapping("/projects")
class ProjectController(
    private val repository: ProjectRepository,
    private val service: ProjectService
) {

    @PostMapping
    fun create(
        @RequestBody request: ProjectRequest,
               @RequestHeader(name = "Authorization") authorization: String
    ): ResponseEntity<Any> {

        val createdBy = createdBy(authorization)

        val project = service.create(request.toModel(createdBy))

        return ResponseEntity.created(URI("/projects/${project.id}")).body(project)
    }

    private fun createdBy(authorization: String): User {
        return User(UUID.randomUUID(), "teste", "testename")
    }

    @GetMapping()
    fun listAll(pageable: Pageable) : ResponseEntity<CollectionModel<Project>> {

        val page = repository.findAll(pageable)

        return ResponseEntity.ok(PagedModel.of(page.content))
    }

    @GetMapping("/{projectId}")
    fun detail(@PathVariable("projectId") id: UUID): ResponseEntity<Project> {

        val op = repository.findById(id)
        if (op.isPresent) {
            return ResponseEntity.ok(op.get())
        }
        return ResponseEntity.notFound().build()
    }

}

class ProjectResponse(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("name")
    val name: String?,
    @JsonProperty("description")
    val description: String?
) : RepresentationModel<ProjectResponse>()
