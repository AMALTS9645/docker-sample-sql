package com.ust.app.customerapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customerData") // optional annotation,sets a name for a database table
public class Customer {
	@Id
	private int id;
	@Column(name = "customer_name", length = 50, nullable = false) //optional
	private String name;
	@Column(unique = true)
	private String email;
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private UserType type;

}
