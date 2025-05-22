package com.caiocaminha.javadailyexpenses.core.gateway.r2dbc.entities;

import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("user_details")
public record UserDetailsEntity(
        String id
) {
}
