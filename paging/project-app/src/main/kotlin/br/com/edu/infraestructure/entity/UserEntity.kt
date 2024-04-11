package br.com.edu.infraestructure.entity

import br.com.edu.domain.model.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "Users")
class UserEntity (

    @Id
    @Column(name = "id")
    var id: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "username")
    var username: String
) {

    constructor(): this(UUID.randomUUID().toString(), "", "")

    fun toModel() = User(UUID.fromString(id), name, username)

    companion object {
        fun fromModel(user: User): UserEntity {
            return UserEntity(user.id.toString(), user.name, user.username)
        }
    }

}