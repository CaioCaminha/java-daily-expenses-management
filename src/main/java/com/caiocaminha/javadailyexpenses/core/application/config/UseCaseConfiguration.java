package com.caiocaminha.javadailyexpenses.core.application.config;

import com.caiocaminha.javadailyexpenses.core.usecase.CreateTransactionUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    public CreateTransactionUseCase createTransactionUseCase() {
        return new CreateTransactionUseCase();
    }

}
