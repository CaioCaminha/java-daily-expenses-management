package com.caiocaminha.javadailyexpenses.core.domain.entities;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;


/**
 * When creating a record, the compiler generates:
 *  - Immutable class with all the fields passed (just like final fields)
 *  - cannonical constructor to initialize the fields
 *  - toString, equals and hashCode with implementation similar to what an ide would do
 *  - it can implement serializable interface
 *
 * The generated class (by the compiler) is a final class, just as the properties
 * record keyword result in a class that extends Record class, so a record class cannot extend any class
 *
 * Documentation suggestion: If the components of your record are not immutable you should consider making defensive
 * copies of them in both the canonical constructor and the accessors
 */
public record UserDetails(
        UUID id,
        String firstName,
        String lastName,
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements Serializable {

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
