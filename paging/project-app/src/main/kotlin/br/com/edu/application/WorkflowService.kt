package br.com.edu.application

import br.com.edu.domain.model.Project
import br.com.edu.domain.repository.ProjectRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class WorkflowService(
    private val repository: ProjectRepository
) {

    @Async
    fun dispatch(project: Project) {
        Thread.sleep(2000)
        val executionId = UUID.randomUUID()

        project.executionId = executionId

        repository.save(project)
    }

}
