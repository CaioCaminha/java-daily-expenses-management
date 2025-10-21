package com.caiocaminha.javadailyexpenses.core.domain.entities;


import java.time.LocalDateTime;
import java.util.UUID;

public record UserDetails(
        UUID id,
        String firstName,
        String lastName,
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public UserDetails(
            String firstName,
            String lastName,
            String username,
            String email
    ) {
        this(
                UUID.randomUUID(),
                firstName,
                lastName,
                username,
                email,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}
