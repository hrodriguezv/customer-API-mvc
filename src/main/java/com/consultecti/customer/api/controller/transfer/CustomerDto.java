/**
 * 
 */
package com.consultecti.customer.api.controller.transfer;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.consultecti.customer.api.model.domain.CustomerStatus;
import com.consultecti.customer.api.util.ApiDocUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
public class CustomerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -809040863811476221L;

	@ApiModelProperty(notes = "${apidoc.ID}", required = true, allowEmptyValue = false, example = "1")
	@NotNull 
	Long id;

	@ApiModelProperty(notes = "${apidoc.NAME}", required = true, allowEmptyValue = false, example = ApiDocUtil.NAME)
	@NotBlank
	private String name;
	
	@ApiModelProperty(notes = "${apidoc.LASTNAME}", required = true, allowEmptyValue = false, example = ApiDocUtil.LASTNAME)
	@NotBlank
	private String lastName;
	
	@ApiModelProperty(notes = "${apidoc.USERNAME}", required = true, allowEmptyValue = false, example = ApiDocUtil.USERNAME)
	@NotBlank
	private String username;

	@ApiModelProperty(notes = "${apidoc.EMAIL}", required = true, allowEmptyValue = false, example = ApiDocUtil.EMAIL)
	@NotBlank
	@Email
	private String email;
	
	@ApiModelProperty(notes = "${apidoc.ADDRESS}", required = true, allowEmptyValue = false, example = ApiDocUtil.ADDRESS)
	@NotBlank
	
	private String address;
	@ApiModelProperty(notes = "${apidoc.STATUS}", required = true, allowEmptyValue = false, example = ApiDocUtil.STASTUS)
	private CustomerStatus status;
	
	@ApiModelProperty(notes = "Customer date", required = true, allowEmptyValue = false, example = "24/09/2019")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private ZonedDateTime dateCreated;

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
}
