package com.spring.Banking.Repository;

import com.spring.Banking.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepositoryImp extends JpaRepository<TransactionEntity,Long> {


    Optional<TransactionEntity> findByTransactionId(String transactionId);
}
