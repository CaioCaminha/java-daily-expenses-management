package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

public class OpenAIGateway {
    private final OpenAiHttpClient httpClient;

    public OpenAIGateway(
            OpenAiHttpClient httpClient
    ) {
        this.httpClient = httpClient;
    }

    public Set<TransactionDetails> calculateCategories(Set<TransactionDetails> statements) {
        //todo pending implementation
        return null;
    }
}
