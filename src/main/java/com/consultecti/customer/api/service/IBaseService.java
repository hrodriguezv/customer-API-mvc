/**
 * 
 */
package com.consultecti.customer.api.service;

import java.io.Serializable;

/**
 * This class is generic for all services that implement access to data objects
 * @author amelendez
 * @since Sep 24, 2019
 */
public interface IBaseService <Entity, ID extends Serializable> {
	
	/**
	 * Save a Generic EntityDomainModel
	 * @param entity
	 * @return instanceOf to the Entity
	 */
	Entity add(final Entity entity);
	
	
	/**
	 * Update a Generic EntityDomainModel
	 * @param entity
	 * @return instanceOf to the Entity
	 */
	Entity update(final Entity entity);
	
	/**
	 * Delete a Generic EntityDomainModel
	 * @param id
	 */
	void delete(final ID id);
	
	/**
	 * Find a EntityDomainModel associated with a unique Id
	 * @param id
	 * @return EntityDomainModel
	 */
	Entity findById(final ID id);
	
	/**
	 * Find All EntityDomainModel instanceOf Entity
	 * @return Iterable
	 */
	Iterable<Entity> findAll();
}
