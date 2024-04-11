package br.com.edu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class ProjectApplication

fun main(args: Array<String>) {
    runApplication<ProjectApplication>(*args)
}
