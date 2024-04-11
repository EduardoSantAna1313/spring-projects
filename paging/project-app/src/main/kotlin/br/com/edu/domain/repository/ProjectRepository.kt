package br.com.edu.domain.repository

import br.com.edu.domain.model.Project
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface ProjectRepository {

    fun save(project: Project): Project

    fun findAll(pageable: Pageable): Page<Project>

    fun findById(id: UUID): Optional<Project>

}