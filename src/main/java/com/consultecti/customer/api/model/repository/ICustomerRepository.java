/**
 * 
 */
package com.consultecti.customer.api.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.consultecti.customer.api.model.domain.Customer;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}
