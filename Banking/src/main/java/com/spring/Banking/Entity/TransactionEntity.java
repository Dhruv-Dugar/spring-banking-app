package com.spring.Banking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="Transactions",
        uniqueConstraints = @UniqueConstraint(
                name = "transactionUuid_unique", columnNames = "transaction_uuid"
        )
)
public class TransactionEntity {
    @Id
    @Column(name = "transaction_uuid",nullable = false)
    private String transactionUuid;
    private String senderUuid;
    private String receiverUuid;
    private long amount;

}
