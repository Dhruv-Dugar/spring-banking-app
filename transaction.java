package com.spring.Banking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    // Mock method to fetch transaction details
    private String fetchTransactionById(String transactionId) {
        // Simulate a data fetch. Replace this with actual database logic.
        if ("12345".equals(transactionId)) {
            return "Transaction details for ID: 12345";
        }
        return null; // Simulates not found
    }

    // Endpoint to get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getTransactionById(@PathVariable("id") String transactionId) {
        // Fetch the transaction details
        String transactionDetails = fetchTransactionById(transactionId);

        if (transactionDetails == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Transaction not found for ID: " + transactionId);
        }

        return ResponseEntity.ok(transactionDetails);
    }
}
