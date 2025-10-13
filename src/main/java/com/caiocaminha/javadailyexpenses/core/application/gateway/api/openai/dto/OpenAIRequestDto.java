package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.dto;

public record OpenAIRequestDto (
        String model,
        String input
){

    public OpenAIRequestDto(
            String input
    ) {
        this.model = "";
        this.input = input;
    }

}
