package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;

import java.util.Set;

public class OpenAIGateway {
    private final OpenAiHttpClient httpClient;
    private final OpenAiClientProperties properties;

    public OpenAIGateway(
            OpenAiHttpClient httpClient,
            OpenAiClientProperties properties
    ) {
        this.httpClient = httpClient;
        this.properties = properties;
    }

    public Set<TransactionDetails> calculateCategories(Set<TransactionDetails> statements) {
        //todo pending implementation
        return null;
    }
}
