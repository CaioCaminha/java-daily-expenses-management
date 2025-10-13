package com.caiocaminha.javadailyexpenses.core.domain.entities;

import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDetails(
        UUID id,
        String hash,
        UUID userId,
        Category category,
        DescriptionDetails descriptionDetails,
        Double cost,
        LocalDate transactionDate,
        String paidBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    //todo Not sure this constructor signature it's working
    public TransactionDetails(
            UUID userId,
            Category category,
            String description,
            Double cost,
            LocalDate transactionDate,
            String paidBy,
            LocalDateTime createdAt
    ) {
        id = UUID.randomUUID();
        hash = String.valueOf((userId.toString() + descriptionDetails.description() + cost + transactionDate).hashCode());
        updatedAt = createdAt; // at construction the updatedAt should be equals to createdAt
    }

}
