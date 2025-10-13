package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai;

import com.caiocaminha.javadailyexpenses.core.application.gateway.api.shared.ExchangeFiltersProvider;
import com.caiocaminha.javadailyexpenses.core.utils.WebClientBuilder;
import com.caiocaminha.javadailyexpenses.core.utils.WebClientConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Configuration
public class OpenAiWebClientConfig {


    /**
     * todo Expose an endpoint to evaluate performance of OpenAI on extracting categories out of transactions descriptions
     */


    @Value("${client.base-url.open-ai}")
    private String baseUrl;

    private final WebClientBuilder webClientBuilder;

    private final WebClientConfig webClientConfig;

    public OpenAiWebClientConfig(
            WebClientConfig webClientConfig,
            WebClientBuilder webClientBuilder
    ) {
        this.webClientBuilder = webClientBuilder;
        this.webClientConfig = webClientConfig;
    }

    private HttpClient httpClient() {
        return webClientBuilder.httpClient(
                "openai-http-client", webClientConfig
        );
    }


    @Bean
    public WebClient openAiWebClient() {
        return webClientBuilder.build(
                this.baseUrl,
//                Optional.of(filters.stream().map(ExchangeFiltersProvider::filter).toList()),
                Optional.empty(),
                httpClient(),
                ClientCodecConfigurer::defaultCodecs
        );
    }





}
