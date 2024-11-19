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
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String transactionId;
    private String senderUuid;
    private String receiverUuid;
    private long amount;

    public TransactionEntity(String transactionId, String senderUuid, String receiverUuid, long amount) {
        this.transactionId = transactionId;
        this.senderUuid = senderUuid;
        this.receiverUuid = receiverUuid;
        this.amount = amount;
    }

    //    private String status;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSenderUuid() {
        return senderUuid;
    }

    public void setSenderUuid(String senderUuid) {
        this.senderUuid = senderUuid;
    }

    public String getReceiverUuid() {
        return receiverUuid;
    }

    public void setReceiverUuid(String receiverUuid) {
        this.receiverUuid = receiverUuid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
