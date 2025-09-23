package com.caiocaminha.javadailyexpenses.core.application.gateway.controller.transaction;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TransactionRouter {

    private final TransactionHandler transactionHandler;

    public TransactionRouter(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    public RouterFunction<ServerResponse> transactionRoutes() {
        return route(
                POST("/v1/statement").and(accept(APPLICATION_JSON)),
                transactionHandler::createTransaction
        )
//                .andRoute(
//                GET("/v1/statement").and(accept(APPLICATION_JSON)),
//                todo: create handler for GET function
//        )
                ;
    }

}
