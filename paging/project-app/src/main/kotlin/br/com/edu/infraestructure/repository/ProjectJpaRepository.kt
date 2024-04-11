package br.com.edu.infraestructure.repository

import br.com.edu.domain.model.Project
import br.com.edu.domain.repository.ProjectRepository
import br.com.edu.infraestructure.entity.ProjectEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Repository
class ProjectJpaRepository(
    private val repository: InternalRepository
): ProjectRepository {

    override fun save(project: Project): Project {

        val entity = ProjectEntity.fromModel(project)

        return repository.save(entity).toModel()
    }

    override fun findAll(pageable: Pageable): Page<Project> {
        return repository.findAll(pageable).map { it.toModel() }
    }

    override fun findById(id: UUID): Optional<Project> {

        val op = repository.findById(id.toString())

        return Optional.ofNullable(op.getOrNull()?.toModel())
    }

}

@Repository
interface InternalRepository : JpaRepository<ProjectEntity, String> {

}