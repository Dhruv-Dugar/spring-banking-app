package com.spring.Banking.Service;

import com.spring.Banking.Entity.CustomerEntity;
import com.spring.Banking.Error.CustomerNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import com.spring.Banking.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplementation.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerEntity> getAllCustomers() {
        logger.debug("Retrieving all Customers from Database");
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity updateCustomer(String id, CustomerEntity customerDetails) {
        // Find the customer by ID, if found, update and save it, otherwise return null
        CustomerEntity customer = customerRepository.findById(id).orElse(null);

        if (customer != null) {
            customer.setFirstName(customerDetails.getFirstName());
            customer.setLastName(customerDetails.getLastName());
            customer.setEmailId(customerDetails.getEmailId());
            return customerRepository.save(customer);
        }

        return null;  // Return null if customer is not found
    }

    @Override
    public CustomerEntity getCustomerById(String id){
//        CustomerEntity
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with given id " + id));
    }
    

    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);  // Save the new customer
    }
}
