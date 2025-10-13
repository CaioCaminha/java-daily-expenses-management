package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.filter;

import com.caiocaminha.javadailyexpenses.core.application.gateway.api.shared.ExchangeFiltersProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Service
public class OpenAIAuthorizationHeaderFilterFunction implements ExchangeFiltersProvider {

    @Value("${client.api-key.open-ai}")
    private String apiKey;

    @Override
    public ExchangeFilterFunction filter() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> Mono.just(ClientRequest.from(clientRequest)
                .header("Authorization", "Bearer %s".formatted(apiKey))
                .build()));
    }

}
