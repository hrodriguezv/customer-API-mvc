/**
 * 
 */
package com.consultecti.customer.api.model.domain;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String address;

	@Enumerated(EnumType.STRING)
	private CustomerStatus status;

	@Column(name = "date_created", nullable = false)
	private ZonedDateTime dateCreated = ZonedDateTime.now(ZoneId.of("UTC-4"));

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Distributor distributor;

	/**
	 * @param name
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param address
	 * @param status
	 * @param distributor
	 */
	public Customer(String name, String lastName, String username, String password, String email,
			String address, CustomerStatus status, Distributor distributor) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.status = status;
		this.distributor = distributor;
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
	 * @return the distributor
	 */
	public Distributor getDistributor() {
		return distributor;
	}

	/**
	 * @param distributor the distributor to set
	 */
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
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
		return "Customer [name=" + name + ", lastName=" + lastName + ", username=" + username
				+ " email=" + email + ", address=" + address + ", dateCreated="
				+ dateCreated + ", status=" + status + "]";
	}
}
