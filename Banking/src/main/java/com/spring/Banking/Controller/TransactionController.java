package com.spring.Banking.Controller;
import com.spring.Banking.Entity.TransactionEntity;
import com.spring.Banking.Service.CustomerService;
import com.spring.Banking.Service.TransactionService;
//import jakarta.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.String;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    // Create a new transaction
    @PostMapping("/create")
    public TransactionEntity createTransaction(@RequestBody TransactionEntity transaction) {
        logger.info("Creating transaction with the following details: {}", transaction);
        return transactionService.createTransaction(transaction);
    }

    // Get all transactions
    @GetMapping("/all")
    public List<TransactionEntity> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get a single transaction by transactionId
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionEntity> getTransaction(@PathVariable String transactionId) {
        TransactionEntity transaction = transactionService.getTransactionById(transactionId);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing transaction
    @PutMapping("/update/{transactionId}")
    public TransactionEntity updateTransaction(
            @PathVariable String transactionId, @RequestBody TransactionEntity transaction) {
        return transactionService.updateTransaction(transactionId, transaction);

    }

    // Delete a transaction by transactionId
    @DeleteMapping("/delete/{transactionId}")
    public boolean deleteTransaction(@PathVariable String transactionId) {
        logger.info("Deleting Transaction with ID "+transactionId);
        return transactionService.deleteTransaction(transactionId);
    }

}
