/**
 * 
 */
package com.consultecti.customer.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.consultecti.customer.api.model.domain.Customer;
import com.consultecti.customer.api.model.domain.CustomerStatus;
import com.consultecti.customer.api.model.repository.ICustomerRepository;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Service
public class CustomerService implements ICustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	private ICustomerRepository customerRepository;
	
	/**
	 * 
	 */
	@Autowired
	public CustomerService(final ICustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Customer add(Customer entity) {
		if(entity == null) {
			return null;
		}
		try {
			return this.customerRepository.save(entity);
		} catch (Exception e) {
			log.error("Error trying save or update a Customer with the data {}", entity, e);
			return null;
		}
	}

	@Override
	public Customer update(Customer entity) {
		return this.add(entity);
	}

	@Override
	public void delete(Long id) {
		try {
			this.customerRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete a Customer with the id {}", id, e);
		}
	}

	@Override
	public Customer findById(Long id) {
		if(id <= 0L) {
			return null;
		}
		try {
			return this.customerRepository.findById(id).get();
		} catch (Exception e) {
			log.error("Error retrieved a Customer by the id {}", id, e);
			return null;
		}
	}

	@Override
	public Iterable<Customer> findAll() {
		try {
			return this.customerRepository.findAll();
		} catch (Exception e) {
			log.error("Error retrieved all Customer", e);
			return null;
		}
	}

	@Override
	public Iterable<Customer> findByUsername(String username) {
		if(username == null || StringUtils.isEmpty(username)) {
			return null;
		}
		try {
			return this.customerRepository.findByUsername(username);
		} catch (Exception e) {
			log.error("Error retrieved all Customer with the same username -> {}", username, e);
			return null;
		}
	}

	@Override
	public Iterable<Customer> findByStatus(CustomerStatus status) {
		if(status == null || StringUtils.isEmpty(status)) {
			return null;
		}
		try {
			return this.customerRepository.findByStatus(status);
		} catch (Exception e) {
			log.error("Error retrieved all Customer with the status -> {}", status, e);
			return null;
		}
	}
}
