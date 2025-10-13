package com.caiocaminha.javadailyexpenses.core.application.gateway.controller.admin;

import com.caiocaminha.javadailyexpenses.core.application.gateway.controller.admin.dto.OpenAICategoryDto;
import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.port.OpenAIService;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Set;

public class AdminHandler {

    private OpenAIService openAIService;

    public AdminHandler(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    public Mono<ServerResponse> callOpenAi(ServerRequest request) {
        var message = request.bodyToMono(OpenAICategoryDto.class).blockOptional();
        openAIService.calculateCategories(
                Set.of()
        );

        return ServerResponse.ok().bodyValue("success");
    }

}
