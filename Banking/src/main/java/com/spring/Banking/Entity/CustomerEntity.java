package com.spring.Banking.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
		name="Customers",
		uniqueConstraints = @UniqueConstraint(
				name = "emailid_unique", columnNames = "email_address"
		)
)
public class CustomerEntity {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer-id")
	private String customerId;

	private String firstName;
	private String lastName;

	@Column(
			name = "email_address", nullable = false
	)
	private String emailId;

	@Enumerated(EnumType.STRING)
	private Bank bankName;

	private long balance;
	// balance can go negative as we allow overdraft functionality, did not keep a @Min with 0

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Bank getBankName() {
		return bankName;
	}

	public void setBankName(Bank bankName) {
		this.bankName = bankName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	// TODO add List<Transactions> post it is made by the other pppl, so we can have that



}
