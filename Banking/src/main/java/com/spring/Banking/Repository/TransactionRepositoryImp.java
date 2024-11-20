package com.spring.Banking.Repository;

import com.spring.Banking.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepositoryImp extends JpaRepository<TransactionEntity,String> {


//    Optional<TransactionEntity> findByTransactionId(String transactionId);
}
