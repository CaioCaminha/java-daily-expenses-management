package com.caiocaminha.javadailyexpenses.core.domain.entities;

import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDetails(
        String id,
        UUID userId,
        Category category,
        String details,
        Double cost,
        LocalDate transactionDate,
        String paidBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public TransactionDetails {
        id = String.valueOf((userId.toString() + details + cost + transactionDate).hashCode());
        updatedAt = createdAt; // at construction the updatedAt should be equals to createdAt
    }

}
