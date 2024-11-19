package com.spring.Banking.Service;

import com.spring.Banking.Entity.CustomerEntity;

import java.util.List;

import com.spring.Banking.Entity.CustomerEntity;
import java.util.Optional;

public interface CustomerService {

    CustomerEntity saveCustomer(CustomerEntity customer);

    List<CustomerEntity> getAllCustomers();

    CustomerEntity updateCustomer(Long id, CustomerEntity customer);

    void deleteCustomer(Long id);
}