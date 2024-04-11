package br.com.edu.infraestructure.entity

import br.com.edu.domain.model.ProjectParameter
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "Parameter")
class ParameterEntity (

    @Id
    @Column(name = "id")
    var id: String,

    @Column(name = "parameter_name")
    var name: String,

    @Column(name = "parameter_value")
    var value: String
) {

    constructor(): this(UUID.randomUUID(), "", "")

    constructor(name: String, value: String): this(UUID.randomUUID(), name, value)
    constructor(id: UUID, name: String, value: String): this(id.toString(), name, value)

    fun toModel() = ProjectParameter(name, value)

    companion object {
        fun fromModel(param: ProjectParameter) : ParameterEntity {
            return ParameterEntity(param.name, param.value)
        }
    }

}