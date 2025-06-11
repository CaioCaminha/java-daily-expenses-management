package com.caiocaminha.javadailyexpenses.core.domain.port;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TransactionDetailsPort {
    public TransactionDetails findByUserId(UUID userId);

    public void upsert(TransactionDetails transactionDetails);
}
