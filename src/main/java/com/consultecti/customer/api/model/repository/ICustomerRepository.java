/**
 * 
 */
package com.consultecti.customer.api.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consultecti.customer.api.model.domain.Customer;
import com.consultecti.customer.api.model.domain.CustomerStatus;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

	@Query("from Customer a where a.username=:pusername")
	public Iterable<Customer> findByUsername(final @Param("pusername") String pusername);
	
	@Query("from Customer a where a.status=:pstatus")
	public Iterable<Customer> findByStatus(final @Param("pstatus") CustomerStatus pstatus);
}
