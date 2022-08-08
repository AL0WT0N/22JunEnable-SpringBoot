package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	//Columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@Column(name = "firstname") // name is used to change the name of the generated column
//	@Column(unique = true)     // adds the unique constraint to the column
//	@Column(length = 50)      // adds a limit to the length of the datatype
	@Column(nullable = false) // adds a not null constraint to the column. (The column can not be null)
	private String firstName; // Creates a column called first_name with the datatype VARCHAR(255)
	
	@Column(nullable = false)
	private String lastName; // Creates a column called last_name with the datatype VARCHAR(255)
	
	@Column(nullable = false)
	private int age;        // Creates a column called age with the datatype INT.

	// Constructors
	// Default constructor (for Spring)
	public Customer() {}
	
	// For creating (without ID)
	public Customer(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	// For reading (with ID)
	public Customer(long id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	// Override methods
	// For testing
	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}	
}
