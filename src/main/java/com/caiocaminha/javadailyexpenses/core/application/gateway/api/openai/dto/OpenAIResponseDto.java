package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.dto;

public record OpenAIResponseDto(
        String id,
        String type,
        String role,
        Content content
) {}
