/**
 * 
 */
package com.consultecti.customer.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultecti.customer.api.model.domain.Distributor;
import com.consultecti.customer.api.model.repository.IDistributorRepository;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Service
public class DistributorService implements IDistributorService {

	private static final Logger log = LoggerFactory.getLogger(DistributorService.class);
	private IDistributorRepository distributorRepository;
	
	/**
	 * 
	 */
	@Autowired
	public DistributorService(final IDistributorRepository distributorRepository) {
		this.distributorRepository = distributorRepository;
	}
	
	@Override
	public Distributor add(Distributor entity) {
		if(entity == null) {
			return null;
		}
		try {
			return this.distributorRepository.save(entity);
		} catch (Exception e) {
			log.error("Error trying save or update a Distributor with the data {}", entity, e);
			return null;
		}
	}

	@Override
	public Distributor update(Distributor entity) {
		return this.add(entity);
	}

	@Override
	public void delete(Long id) {
		try {
			this.distributorRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete a Distributor with the id {}", id, e);
		}
	}

	@Override
	public Distributor findById(Long id) {
		if(id <= 0L) {
			return null;
		}
		try {
			return this.distributorRepository.findById(id).get();
		} catch (Exception e) {
			log.error("Error retrieved  a Distributor by the id {}", id, e);
			return null;
		}
	}

	@Override
	public Iterable<Distributor> findAll() {
		try {
			return this.distributorRepository.findAll();
		} catch (Exception e) {
			log.error("Error retrieved all Distributor", e);
			return null;
		}
	}

}
