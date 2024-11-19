package com.spring.Banking.Controller;


import com.spring.Banking.Entity.CustomerEntity;
import com.spring.Banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	private final CustomerService customerService;


	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public CustomerEntity getCustomerById(@PathVariable("id") long customerId){
		return customerService.getCustomerById(customerId);
	}

	@PostMapping
	public CustomerEntity createCustomer(@RequestBody CustomerEntity customer){
		return customerService.createCustomer(customer);
	}

	@PutMapping("/{id}")
	public CustomerEntity updateCustomer(@RequestBody CustomerEntity customer, @PathVariable long    customerId){
		return customerService.updateCustomer(customer, customerId);
	}

	
	// bank has no delete method due to KYC reasons and regulations
}
