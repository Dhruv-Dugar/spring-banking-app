package com.spring.Banking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    // DTO to receive transaction details
    public static class TransactionRequest {
        private String transactionId;

        // Getters and Setters
        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }
    }

    // Endpoint to handle the transaction request
    @PostMapping
    public ResponseEntity<String> processTransaction(@RequestBody TransactionRequest request) {
        // Extract transaction ID from request
        String transactionId = request.getTransactionId();

        // Business logic to process the transaction
        if (transactionId == null || transactionId.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Transaction ID is required");
        }

        // Mock processing
        boolean success = processTransactionLogic(transactionId);

        if (success) {
            return ResponseEntity.ok("Transaction processed successfully for ID: " + transactionId);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to process the transaction for ID: " + transactionId);
        }
    }

    // Mock method to simulate transaction processing
    private boolean processTransactionLogic(String transactionId) {
        // Simulated logic
        return !transactionId.startsWith("fail");
    }
}
