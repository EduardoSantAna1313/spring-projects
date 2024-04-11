package br.com.edu.application

import br.com.edu.domain.model.Project
import br.com.edu.domain.repository.ProjectRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val repository: ProjectRepository,

    private val service: WorkflowService
) {

    @Transactional
    fun create(project: Project) : Project {
        val saved = repository.save(project)

        service.dispatch(project)

        return saved
    }

}