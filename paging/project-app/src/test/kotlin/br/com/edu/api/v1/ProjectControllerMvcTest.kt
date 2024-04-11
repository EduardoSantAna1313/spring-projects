package br.com.edu.api.v1

import br.com.edu.domain.repository.ProjectRepository
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.net.URI
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@AutoConfigureMockMvc
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ProjectControllerMvcTest(
    @Autowired
    private val mvc: MockMvc,

) {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun test1() {
        assertEquals(1, 1)
    }

    @Test
    fun `should Create Project`() {

        mvc.perform(MockMvcRequestBuilders.post(URI.create("/projects"))
            .header("Authorization", "Bearer token")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                    "name": "Project 1",
                    "description": "Project for testing spring",
                    "versions": [],
                    "parameters": []
                }
                """)
            )
            .andDo { print() }
            .andExpect(status().isOk)

    }
}