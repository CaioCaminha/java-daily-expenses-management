package com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.entities;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;
import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("transaction_details")
public class TransactionDetailsEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column("user_id")
    private UUID userId;
    @Column("details")
    private String details;
    @Column("category")
    private Category category;
    @Column("cost")
    private Double cost;
    @Column("date")
    private LocalDate date;
    @Column("paid_by")
    @Nullable
    private String paidBy;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = this.createdAt;

    public TransactionDetailsEntity(
            UUID userId,
            String details,
            Category category,
            Double cost,
            LocalDate date,
            String paidBy
    ) {
        this.userId = userId;
        this.details = details;
        this.category = category;
        this.cost = cost;
        this.date = date;
        this.paidBy = paidBy;
    }

    public TransactionDetails toDomain() {
        return new TransactionDetails(
                UUID.fromString(this.id),
                this.userId,
                this.category,
                this.details,
                this.cost,
                this.date,
                this.paidBy,
                this.createdAt,
                this.updatedAt
        );
    }

}
