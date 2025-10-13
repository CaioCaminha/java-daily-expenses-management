package com.caiocaminha.javadailyexpenses.core.utils;

import com.caiocaminha.javadailyexpenses.core.application.gateway.api.shared.ExchangeFiltersProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.ProxyProvider;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;


@Configuration
public class WebClientBuilder {

    private WebClient.Builder clientBuilder;
    private Set<ExchangeFiltersProvider> filtersProviders;

    public WebClientBuilder(
            WebClient.Builder clientBuilder,
            //todo according to spring documentation this is the proper setup, also supports an array
            // like ExchangeFiltersProviders[]
            Set<ExchangeFiltersProvider> filters
    ) {
        this.clientBuilder = clientBuilder;
        this.filtersProviders = filters;
    }

    private final int maxMemory = 12 * 1024;
    private final int byteSize = 1024;


    public HttpClient httpClient(
            String name,
            WebClientConfig config
    ) {
        var httpClient = HttpClient.create(
                ConnectionProvider.builder("http-connection-pool-%s".formatted(name))
                        .maxConnections(config.maxConnections)
                        .pendingAcquireTimeout(Duration.ofSeconds(config.acquireTimeout))
                        .build()
        );
        if(!config.proxyHost.isBlank()){
            httpClient.proxy(
                    (proxy) -> {
                            proxy.type(ProxyProvider.Proxy.HTTP)
                                    .host(config.proxyHost)
                                    .port(Integer.parseInt(config.proxyPort));
                    }
            );
        }
        return httpClient.compress(true);
    }

    public WebClient build(
            String baseUrl,
            Optional<List<ExchangeFilterFunction>> changeUrlFilters,
            HttpClient httpClient,
            Consumer<ClientCodecConfigurer> codecConfigurer
    ) {
        var connector = new ReactorClientHttpConnector(httpClient);
        return clientBuilder.clone().baseUrl(baseUrl)
                .clientConnector(connector)
                .codecs(codec -> codec.defaultCodecs().maxInMemorySize(maxMemory * byteSize))
                .codecs(codecConfigurer)
                .filters(
                        filter -> {
                            changeUrlFilters.ifPresent(filter::addAll);
                            filter.add(logResponseFilter());
                            filter.addAll(
                                    filtersProviders
                                            .stream()
                                            .map(ExchangeFiltersProvider::filter)
                                            .toList()
                            );
                        }
                )
                .build();
    }

    /**
     * Returns ExchangeFilterFunction that logs the response body
     * @return
     */
    private ExchangeFilterFunction logResponseFilter() {
        return (request, next) -> next.exchange(request)
                .flatMap(response -> response.bodyToMono(String.class)
                        .doOnNext(LoggerUtils::logInfo) //method reference that receives the String body
                        .then(Mono.just(response))
                );
    }




}


