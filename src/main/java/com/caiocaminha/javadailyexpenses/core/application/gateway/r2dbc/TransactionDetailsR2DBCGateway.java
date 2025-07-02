package com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc;

import com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.repositories.TransactionDetailsRepository;
import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.port.TransactionDetailsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionDetailsR2DBCGateway implements TransactionDetailsPort {

    private TransactionDetailsRepository transactionDetailsRepository;

    private R2dbcEntityTemplate r2dbcEntityTemplate;

    public TransactionDetailsR2DBCGateway(
            TransactionDetailsRepository repository,
            R2dbcEntityTemplate r2dbcEntityTemplate
    ) {
        this.transactionDetailsRepository = repository;
        this.r2dbcEntityTemplate = r2dbcEntityTemplate;
    }

    //TODO - Finish R2DBC Implementation creating entities, repositories and gateways

    @Override
    public TransactionDetails findByUserId(UUID userId) {
        return null;
    }

    @Override
    public void upsert(TransactionDetails transactionDetails) {

    }

}
