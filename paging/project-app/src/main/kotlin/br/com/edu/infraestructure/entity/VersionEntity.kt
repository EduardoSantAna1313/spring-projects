package br.com.edu.infraestructure.entity

import br.com.edu.domain.model.DocType
import br.com.edu.domain.model.Documentation
import br.com.edu.domain.model.ProjectVersion
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "Version")
class VersionEntity (

    @Id
    @Column(name = "id")
    var id: String,

    @Column(name = "version")
    var version: String,

    @Column(name = "documentation")
    var documentation: String,

    @Column(name = "doc_type")
    @Enumerated(EnumType.STRING)
    var docType: DocType
) {

    constructor(): this(UUID.randomUUID().toString(), "", "", DocType.MARKDOWN)

    fun toModel(): ProjectVersion {
        return ProjectVersion(UUID.fromString(id), version, Documentation(documentation, docType))
    }

    companion object {

        fun fromModel(version: ProjectVersion): VersionEntity {
            return VersionEntity(version.id.toString(), version.version, version.documentation.value, version.documentation.type)
        }

    }

}