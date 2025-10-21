package com.caiocaminha.javadailyexpenses.core.domain.entities;

import java.time.LocalDate;
import java.util.UUID;

public record AlertDetails(
        UUID id,
        UUID userId,
        AlertType type,
        LocalDate dueDate
){}


