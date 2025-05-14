package com.caiocaminha.javadailyexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class JavaDailyExpensesApplication {

    ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        SpringApplication.run(JavaDailyExpensesApplication.class, args);
    }

}
