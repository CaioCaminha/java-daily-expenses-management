package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

public class OpenAIClientGateway {
    private final OpenAiHttpClient httpClient;
    private final OpenAiClientProperties properties;

    @Value("${open-api.apiKey}")
    private String apiKey;

    public OpenAIClientGateway(
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
