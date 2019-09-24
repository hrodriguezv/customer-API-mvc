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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	private String name;

	private String email;

	private String address;

	private ZonedDateTime dateCreated;

	@OneToMany(mappedBy = "distributor", cascade = CascadeType.ALL)
	private List<Customer> customers = new ArrayList<>();

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param address
	 * @param dateCreated
	 */
	public Distributor(Long id, String name, String email, String address, ZonedDateTime dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 */
	public Distributor() {
		super();
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
		return "Distributor [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", dateCreated=" + dateCreated + "]";
	}
}
