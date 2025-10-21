package com.caiocaminha.javadailyexpenses.core.application.gateway.controller.transaction.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public record TestingRequestDto(
        String id,
        String details,
        Timestamp date,
        BigDecimal amount
) {
}
