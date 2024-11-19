package com.spring.Banking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long transactionId;
    private long senderUuid;
    private long receiverUuid;
    private long amount;

    public TransactionEntity(long senderUuid, long transactionId, long receiverUuid, long amount) {
        this.senderUuid = senderUuid;
        this.transactionId = transactionId;
        this.receiverUuid = receiverUuid;
        this.amount = amount;
    }
//    private String status;


    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getSenderUuid() {
        return senderUuid;
    }

    public void setSenderUuid(long senderUuid) {
        this.senderUuid = senderUuid;
    }

    public long getReceiverUuid() {
        return receiverUuid;
    }

    public void setReceiverUuid(long receiverUuid) {
        this.receiverUuid = receiverUuid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
