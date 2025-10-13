package com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai;

import com.caiocaminha.javadailyexpenses.core.application.gateway.api.openai.dto.OpenAIRequestDto;
import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.port.OpenAIService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OpenAIClientGateway implements OpenAIService {
    private final OpenAiHttpClient httpClient;

    public OpenAIClientGateway(
            OpenAiHttpClient httpClient
    ) {
        this.httpClient = httpClient;
    }

    private String input = """
            
            
            
            
            
            """;

    @Override
    public Set<TransactionDetails> calculateCategories(Set<TransactionDetails> statements) {

        List<String> categories = statements.stream().map(TransactionDetails::category).map(Object::toString).toList();

        httpClient.getCategories(
            OpenAIRequestDto()
        )

        return null;
    }
}
