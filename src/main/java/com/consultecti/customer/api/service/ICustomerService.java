/**
 * 
 */
package com.consultecti.customer.api.service;

import com.consultecti.customer.api.model.domain.Customer;
import com.consultecti.customer.api.model.domain.CustomerStatus;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
public interface ICustomerService extends IBaseService<Customer, Long> {


	/**
	 * Find a all Customer associated with a the same username
	 * @param username
	 * @return Iterable of <code>Customer</code>
	 */
	Iterable<Customer> findByUsername(final String username);
	
	/**
	 * Find a all Customer associated with a status (ENABLED, DISABLED)
	 * @param status
	 * @return Iterable of <code>Customer</code>
	 */
	Iterable<Customer> findByStatus(final CustomerStatus status);
}
