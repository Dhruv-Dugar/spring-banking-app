package com.spring.Banking.Repository;

import com.spring.Banking.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepositoryImp extends JpaRepository<TransactionEntity,Long> {


}
