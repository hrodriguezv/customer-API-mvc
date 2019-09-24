/**
 * 
 */
package com.consultecti.customer.api.model.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author amelendez
 * @since Sep 23, 2019
 */
@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7817267989373431468L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String lastName;

	private String username;

	private String password;

	private String email;

	private String address;

	private ZonedDateTime dateCreated;

	@Enumerated(EnumType.STRING)
	private CustomerStatus status;

	/**
	 * @param id
	 * @param name
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param address
	 * @param dateCreated
	 * @param status
	 */
	public Customer(Long id, String name, String lastName, String username, String password, String email,
			String address, ZonedDateTime dateCreated, CustomerStatus status) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.dateCreated = dateCreated;
		this.status = status;
	}

	/**
	 * 
	 */
	public Customer() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dateCreated
	 */
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the status
	 */
	public CustomerStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCreated, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", address=" + address + ", dateCreated="
				+ dateCreated + ", status=" + status + "]";
	}
}
