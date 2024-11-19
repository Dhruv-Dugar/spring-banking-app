package com.spring.Banking.Service;

import com.spring.Banking.Entity.CustomerEntity;

import java.util.List;

import com.spring.Banking.Entity.CustomerEntity;
import java.util.Optional;

public interface CustomerService {

    CustomerEntity createCustomer(CustomerEntity customer);

    List<CustomerEntity> getAllCustomers(); //done

    CustomerEntity getCustomerById(long customerId);

    CustomerEntity updateCustomer(long id, CustomerEntity customer);

//    void deleteCustomer(Long id);
}