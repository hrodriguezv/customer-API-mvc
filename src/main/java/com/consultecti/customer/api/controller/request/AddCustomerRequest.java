/**
 * 
 */
package com.consultecti.customer.api.controller.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.consultecti.customer.api.util.ApiDocUtil;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
public class AddCustomerRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7882602772960060778L;

	@ApiModelProperty(notes = "${apidoc.NAME}", required = true, allowEmptyValue = false, example = ApiDocUtil.NAME)
	@NotBlank
	private String name;
	
	@ApiModelProperty(notes = "${apidoc.LASTNAME}", required = true, allowEmptyValue = false, example = ApiDocUtil.LASTNAME)
	@NotBlank
	private String lastName;
	
	@ApiModelProperty(notes = "${apidoc.USERNAME}", required = true, allowEmptyValue = false, example = ApiDocUtil.USERNAME)
	@NotBlank
	private String username;
	
	@ApiModelProperty(notes = "${apidoc.PASSWORD}", required = true, allowEmptyValue = false, example = ApiDocUtil.PASSWORD)
	@NotBlank
	private String password;
	
	@ApiModelProperty(notes = "${apidoc.EMAIL}", required = true, allowEmptyValue = false, example = ApiDocUtil.EMAIL)
	@NotBlank
	@Email
	private String email;
	
	@ApiModelProperty(notes = "${apidoc.ADDRESS}", required = true, allowEmptyValue = false, example = ApiDocUtil.ADDRESS)
	@NotBlank
	private String address;

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
}
