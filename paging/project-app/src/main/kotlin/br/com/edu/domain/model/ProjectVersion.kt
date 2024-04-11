package br.com.edu.domain.model

import java.util.UUID

class ProjectVersion (
    val id : UUID,
    val version: String,
    val documentation: Documentation
) {

}
