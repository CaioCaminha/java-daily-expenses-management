package com.caiocaminha.javadailyexpenses.core.domain.entities;

import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record TransactionDetails(
        UUID id,
        UUID userId,
        Category category,
        String details,
        Double cost,
        LocalDate transactionDate,
        String paidBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
