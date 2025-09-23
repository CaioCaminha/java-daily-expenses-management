package com.caiocaminha.javadailyexpenses.core.application;

import com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.config.R2DBCProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@EnableConfigurationProperties({R2DBCProperties.class})
@EnableAsync
public class JavaDailyExpensesApplication {

    //todo Evaluate the best database for this application's usecase - Probably mongo hosted or not

    public static void main(String[] args) {
//        Undertow server = Undertow.builder()
//                .addHttpListener(8080, "localhost")
//                .setHandler(
//                        new HttpHandler() {
//                            @Override
//                            public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
//                                httpServerExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//                                httpServerExchange.getResponseSender().send("Hello World");
//                            }
//                        }
//                ).build();
//        server.start();
        SpringApplication.run(JavaDailyExpensesApplication.class, args);
    }

}
