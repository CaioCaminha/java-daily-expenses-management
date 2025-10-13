package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Content(
    String type,
    String text
) {}
