package com.spring.Banking.Service;
import com.spring.Banking.Entity.TransactionEntity;
//import com.spring.Banking.Model.Transaction;
import com.spring.Banking.Repository.TransactionRepositoryImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransactionServiceImp implements TransactionService{

    @Autowired
    private TransactionRepositoryImp transactionRepository;

    // Create a new transaction
    public TransactionEntity createTransaction(TransactionEntity transaction) {
        transaction.setTransactionId(long.randomUUID()); // Ensure a new UUID for transaction
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get a transaction by transactionId
    public TransactionEntity getTransactionById(long transactionId) {
        Optional<TransactionEntity> transaction = transactionRepository.findByTransactionId(transactionId);
        return transaction.orElse(null);
    }

    // Update an existing transaction
    @Transactional
    public TransactionEntity updateTransaction(long transactionId, TransactionEntity updatedTransaction) {
        Optional<TransactionEntity> existingTransaction = transactionRepository.findByTransactionId(transactionId);

        if (existingTransaction.isPresent()) {
            TransactionEntity transaction = existingTransaction.get();

            // Update fields of the transaction (can be customized as needed)
            transaction.setAmount(updatedTransaction.getAmount());
//            transaction.setstatus(updatedTransaction.getStatus());
            transaction.setSenderUuid(updatedTransaction.getSenderUuid());
            transaction.setReceiverUuid(updatedTransaction.getReceiverUuid());

            return transactionRepository.save(transaction);
        } else {
            return null; // Return null if transaction doesn't exist
        }
    }

    // Delete a transaction by transactionId
    @Transactional
    public boolean deleteTransaction(long transactionId) {
        Optional<TransactionEntity> transaction = transactionRepository.findByTransactionId(transactionId);
        if (transaction.isPresent()) {
            transactionRepository.delete(transaction.get());
            return true;
        }
        return false; // Return false if transaction doesn't exist
    }
}
