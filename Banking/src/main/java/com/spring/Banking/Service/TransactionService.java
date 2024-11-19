package com.spring.Banking.Service;

import com.spring.Banking.Entity.TransactionEntity;

import java.util.List;

public interface TransactionService {

    TransactionEntity createTransaction(TransactionEntity transaction);
    List<TransactionEntity> getAllTransactions();
    TransactionEntity getTransactionById(String transactionId);
    TransactionEntity updateTransaction(String transactionId, TransactionEntity updatedTransaction);
    boolean deleteTransaction(String transactionId);
}
