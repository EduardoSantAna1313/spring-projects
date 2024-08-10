package com.techbank.account.query


import com.techbank.account.query.api.queries.*
import com.techbank.cqrs.core.infraestructure.QueryDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class QueryApplication {

    @Autowired
    private lateinit var queryDispatcher: QueryDispatcher

    @Autowired
    private lateinit var  queryHandler: QueryHandler

    @PostConstruct
    fun registerHandlers() {
        queryDispatcher.registerHandler(
            FindAllAccountsQuery::class.java, QueryHandler::handle
        )

        queryDispatcher.registerHandler(
            FindAccountByIdQuery::class.java, queryHandler::handle
        )
        queryDispatcher.registerHandler(
            FindAccountByHolderQuery::class.java, queryHandler::handle
        )
        queryDispatcher.registerHandler(
            FindAccountWithBalanceQuery::class.java, queryHandler::handle
        )
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(QueryApplication::class.java, *args)
}
