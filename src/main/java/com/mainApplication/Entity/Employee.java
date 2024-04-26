package com.mainApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data  // elements Boiler plate code i.e's Getters,setters, toString...
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
	@Column(name = "first_name",nullable = false)
   private String firstName;
	@Column(name = "last_name")
   private String lastName;
	@Column(name="email")
   private String email;
}
