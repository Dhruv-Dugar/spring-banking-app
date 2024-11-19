package com.spring.Banking.Controller;


import com.spring.Banking.Entity.CustomerEntity;
import com.spring.Banking.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private final CustomerService customerService;


	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public CustomerEntity getCustomerById(@PathVariable("id") long customerId){
		logger.info("Fetching customer with ID: {}", customerId);
		return customerService.getCustomerById(customerId);
	}

	@PostMapping
	public CustomerEntity createCustomer(@RequestBody CustomerEntity customer){
		logger.info("Creating customer with the following details: {}", customer);
		return customerService.createCustomer(customer);
	}

	@PutMapping("/{id}")
	public CustomerEntity updateCustomer(@RequestBody CustomerEntity customer, @PathVariable long    customerId){
		logger.info("Customer with id {} updated with new details as {}", customerId, customer);
		return customerService.updateCustomer(customer, customerId);
	}


	// bank has no delete method due to KYC reasons and regulations
}
