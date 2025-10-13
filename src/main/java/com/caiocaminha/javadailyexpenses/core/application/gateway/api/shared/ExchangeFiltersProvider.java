package com.caiocaminha.javadailyexpenses.core.application.gateway.api.shared;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

public interface ExchangeFiltersProvider {

    public ExchangeFilterFunction filter();

}
