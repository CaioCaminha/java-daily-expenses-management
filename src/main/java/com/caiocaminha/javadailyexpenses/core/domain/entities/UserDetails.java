package com.caiocaminha.javadailyexpenses.core.domain.entities;

import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

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
            UUID id,
            String firstName,
            String lastName,
            String username,
            String email,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }
}
