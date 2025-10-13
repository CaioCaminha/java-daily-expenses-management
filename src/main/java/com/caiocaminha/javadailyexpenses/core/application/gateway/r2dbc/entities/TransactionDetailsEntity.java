package com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.entities;

import com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.utils.PersistableEntity;
import com.caiocaminha.javadailyexpenses.core.domain.entities.DescriptionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;
import com.google.cloud.Timestamp;
import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("transaction_details")
public class TransactionDetailsEntity extends PersistableEntity<String> {
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
    @Column("created_at")
    private Timestamp createdAt = Timestamp.now();
    @Column("updated_at")
    private Timestamp updatedAt = this.createdAt;

    @Override
    public String getId() {
        return id;
    }

    @PersistenceCreator
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

//    public TransactionDetails toDomain() {
//        return new TransactionDetails(
//                this.id,
//                this.userId,
//                this.category,
//                new DescriptionDetails(
//                        this.id, this.details
//                ),
//                this.cost,
//                this.date,
//                this.paidBy,
//                this.createdAt.toSqlTimestamp().toLocalDateTime(),
//                this.updatedAt.toSqlTimestamp().toLocalDateTime()
//        );
//    }

}
