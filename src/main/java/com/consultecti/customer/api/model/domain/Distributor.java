/**
 * 
 */
package com.consultecti.customer.api.model.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author amelendez
 * @since Sep 23, 2019
 */
@Entity
public class Distributor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2905769615511801023L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String address;

	@Column(name = "date_created", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@OneToMany(mappedBy = "distributor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Customer> customers = new ArrayList<>();

	/**
	 * @param name
	 * @param email
	 * @param address
	 */
	public Distributor(String name, String email, String address) {;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	/**
	 * 
	 */
	public Distributor() {
		
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

	@Override
	public int hashCode() {
		return Objects.hash(dateCreated, id);
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Distributor))
			return false;
		Distributor other = (Distributor) obj;
		return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Distributor [name=" + name + ", email=" + email + ", address=" + address
				+ ", dateCreated=" + dateCreated + "]";
	}
}
