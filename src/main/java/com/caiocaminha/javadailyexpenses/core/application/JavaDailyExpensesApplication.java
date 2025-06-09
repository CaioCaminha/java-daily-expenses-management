package com.caiocaminha.javadailyexpenses.core.application;

import com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.config.R2DBCProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class JavaDailyExpensesApplication {

    //todo Configure basic setup with R2DBC using postgres configuration and liquibase setup

    public static void main(String[] args) {
        SpringApplication.run(JavaDailyExpensesApplication.class, args);
    }

}
