package br.com.edu.domain.model

class ProjectParameter(
    val name: String,
    val value: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProjectParameter

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}