package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai;

import com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.dto.OpenAIRequestDto;
import com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.dto.OpenAIResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "", accept = MediaType.APPLICATION_JSON_VALUE)
public interface OpenAiHttpClient {

    @GetExchange("/chat/completions")
    OpenAIResponseDto getCategories(
            @RequestBody OpenAIRequestDto request,
            @RequestAttribute("openAiApiKey") String apiKey
    );

}
