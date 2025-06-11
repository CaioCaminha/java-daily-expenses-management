package com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.repositories;

import com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.entities.TransactionDetailsEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface TransactionDetailsRepository extends ReactiveCrudRepository<TransactionDetailsEntity, String> {

    Flux<TransactionDetailsEntity> findByUserId(UUID userId);

}
