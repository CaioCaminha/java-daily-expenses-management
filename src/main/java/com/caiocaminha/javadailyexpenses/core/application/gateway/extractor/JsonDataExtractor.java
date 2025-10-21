package com.caiocaminha.javadailyexpenses.core.application.gateway.extractor;

import com.caiocaminha.javadailyexpenses.core.domain.port.DataExtractorPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class JsonDataExtractor<T> implements DataExtractorPort<T> {

    private final ObjectMapper objectMapper;

    public JsonDataExtractor(
            ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

    @Override
    public T extract(Mono<String> data, Class<T>  classz) throws JsonProcessingException {
        return objectMapper.readValue(data, classz);
    }
}
