package br.com.edu.infraestructure.entity

import br.com.edu.domain.model.Project
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "Project")
class ProjectEntity(

    @Id
    @Column(name = "id")
    var id: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "created_by")
    var createdBy: UserEntity,

    @Column(name = "created_at")
    var createdAt: LocalDateTime,

    @Column(name = "execution_id")
    var executionId: String?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "project_id")
    var versions: Set<VersionEntity>,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "project_id")
    var parameters: Set<ParameterEntity>

) {
    constructor(): this(
        id = UUID.randomUUID().toString(),
        name = "",
        description = "",
        createdBy = UserEntity(UUID.randomUUID().toString(), "" , ""),
        createdAt = LocalDateTime.now(),
        executionId = null,
        versions = mutableSetOf(),
        parameters = mutableSetOf()
    )

    fun toModel() = Project(
        id = UUID.fromString(id),
        name = name,
        description = description,
        createdBy = createdBy.toModel(),
        createdAt = createdAt,
        executionId = if (executionId.isNullOrEmpty()) null else UUID.fromString(executionId),
        versions = versions.map { it.toModel() }.toSet(),
        parameters = parameters.map { it.toModel() }.toSet()
    )

    companion object {
        fun fromModel(project: Project): ProjectEntity {

            val versions = project.versions.map { VersionEntity.fromModel(it) }.toSet()

            val parameters = project.parameters.map { ParameterEntity.fromModel(it) }.toSet()

            val createdBy = UserEntity.fromModel(project.createdBy)

            return ProjectEntity(
                project.id.toString(),
                project.name, project.description,
                createdBy,
                project.createdAt,
                project.executionId?.toString(),
                versions, parameters
            )
        }
    }

}

