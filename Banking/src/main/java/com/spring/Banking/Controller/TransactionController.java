package com.spring.Banking.Controller;
import com.spring.Banking.Entity.TransactionEntity;
import com.spring.Banking.Service.TransactionService;
//import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.String;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Create a new transaction
    @PostMapping("/create")
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity transaction) {
        try {
            TransactionEntity createdTransaction = transactionService.createTransaction(transaction);
            return ResponseEntity.ok(createdTransaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Get all transactions
    @GetMapping("/all")
    public ResponseEntity<List<TransactionEntity>> getAllTransactions() {
        List<TransactionEntity> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
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
    public ResponseEntity<TransactionEntity> updateTransaction(
            @PathVariable String transactionId, @RequestBody TransactionEntity transaction) {
        TransactionEntity updatedTransaction = transactionService.updateTransaction(transactionId, transaction);
        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a transaction by transactionId
    @DeleteMapping("/delete/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String transactionId) {
        boolean deleted = transactionService.deleteTransaction(transactionId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
