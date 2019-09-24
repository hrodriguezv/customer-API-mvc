/**
 * 
 */
package com.consultecti.customer.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Configuration
public class AuthenticationConfig {

	@Value("${authentication.username}")
	private String username;
	@Value("${authentication.password}")
	private String password;
	@Value("${authentication.role}")
	private String role;

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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AuthenticationConfig [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}
