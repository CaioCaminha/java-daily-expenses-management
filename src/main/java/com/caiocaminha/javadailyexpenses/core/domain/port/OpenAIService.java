package com.caiocaminha.javadailyexpenses.core.domain.port;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;

import java.util.Set;

public interface OpenAIService {

    public Set<TransactionDetails> calculateCategories(Set<TransactionDetails> statements);

}
