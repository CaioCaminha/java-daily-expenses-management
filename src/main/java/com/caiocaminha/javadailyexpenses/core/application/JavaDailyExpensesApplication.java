package com.caiocaminha.javadailyexpenses.core.application;

import com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.config.R2DBCProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@EnableConfigurationProperties({R2DBCProperties.class})
public class JavaDailyExpensesApplication {

    //todo Evaluate the best database for this application's usecase - Probably mongo hosted or not

    public static void main(String[] args) {
        SpringApplication.run(JavaDailyExpensesApplication.class, args);
    }

}
