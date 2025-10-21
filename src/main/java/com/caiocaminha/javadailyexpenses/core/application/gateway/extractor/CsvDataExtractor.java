package com.caiocaminha.javadailyexpenses.core.application.gateway.extractor;

import com.caiocaminha.javadailyexpenses.core.domain.port.DataExtractorPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class CsvDataExtractor<T> implements DataExtractorPort<T> {

    @Override
    public T extract(String data, Class<T> classz) throws JsonProcessingException {
        return null;
    }

}
