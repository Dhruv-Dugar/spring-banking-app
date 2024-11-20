package com.spring.Banking.Service;
import com.spring.Banking.Entity.TransactionEntity;
import com.spring.Banking.Error.CustomerNotFoundException;
import com.spring.Banking.Error.TransactionNotFoundException;
import com.spring.Banking.Repository.TransactionRepositoryImp;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImp implements TransactionService{
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplementation.class);

    @Autowired
    private TransactionRepositoryImp transactionRepository;

    // Create a new transaction
    public TransactionEntity createTransaction(TransactionEntity transaction) {
        logger.debug("Creating a new transaction and saving it in the Database");
        transaction.setTransactionId(UUID.randomUUID().toString()); // Ensure a new UUID for transaction
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<TransactionEntity> getAllTransactions() {
        logger.debug("Retrieving all Transactions from Database");
        return transactionRepository.findAll();
    }



    // Get a transaction by transactionId
    public TransactionEntity getTransactionById(String transactionId) {
        logger.debug("Retrieving Transactions with ID : "+transactionId);
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with given id " + transactionId));
    }

    // Update an existing transaction
    @Transactional
    public TransactionEntity updateTransaction(String transactionId, TransactionEntity updatedTransaction) {
        Optional<TransactionEntity> existingTransaction = transactionRepository.findById(transactionId);
        logger.debug("Updating Transaction with ID : "+transactionId);
        if (existingTransaction.isPresent()) {
            TransactionEntity transaction = existingTransaction.get();

            // Update fields of the transaction (can be customized as needed)
            transaction.setAmount(updatedTransaction.getAmount());
//            transaction.setstatus(updatedTransaction.getStatus());
            transaction.setSenderId(updatedTransaction.getSenderId());
            transaction.setReceiverId(updatedTransaction.getReceiverId());

            return transactionRepository.save(transaction);
        } else {
            throw new TransactionNotFoundException("Transaction not found with given id " + transactionId);
        }
    }

    // Delete a transaction by transactionId
    @Transactional
    public boolean deleteTransaction(String transactionId) {
        Optional<TransactionEntity> transaction = transactionRepository.findById(transactionId);
        if (transaction.isPresent()) {
            transactionRepository.delete(transaction.get());
            return true;
        }
        return false; // Return false if transaction doesn't exist
    }
}
