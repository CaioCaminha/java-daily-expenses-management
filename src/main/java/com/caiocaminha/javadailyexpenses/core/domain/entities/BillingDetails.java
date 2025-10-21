package com.caiocaminha.javadailyexpenses.core.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record BillingDetails(
        UUID id,
        UUID userId,
        UUID alertId,
        String description,
        BigDecimal cost,
        LocalDate expirationDate
) {
}
