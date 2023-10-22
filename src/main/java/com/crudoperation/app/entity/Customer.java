package com.crudoperation.app.entity;

import com.crudoperation.app.constants.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;

	private String firstName;
	private String lastName;

	@Column(updatable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(updatable = false)
	private String username;

	@Column(unique = true)
	private String email;

	private String mobile;

	public void beforeSave() {
		this.setUsername(email);
	}

	//@Override
	//public String toString() {
	//	StringBuilder builder = new StringBuilder();
	//	builder.append("Customer [customerId=").append(customerId).append(", firstName=").append(firstName)
	//			.append(", lastName=").append(lastName).append(", gender=").append(gender).append(", gmail=")
	//			.append(email).append(", mobile=").append(mobile).append("]");
	//	return builder.toString();
	//}

}
