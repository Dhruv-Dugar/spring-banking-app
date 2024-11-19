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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer-id")
	private long customerId;

	private String firstName;
	private String lastName;

	@Column(
			name = "email_address", nullable = false
	)
	private String emailId;

	@Enumerated(EnumType.STRING)
	private Bank bankName;

}
