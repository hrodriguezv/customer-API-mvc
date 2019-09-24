/**
 * 
 */
package com.consultecti.customer.api.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultecti.customer.api.controller.request.AddCustomerRequest;
import com.consultecti.customer.api.controller.request.UpdateCustomerRequest;
import com.consultecti.customer.api.controller.transfer.CustomerDto;
import com.consultecti.customer.api.model.domain.Customer;
import com.consultecti.customer.api.model.domain.CustomerStatus;
import com.consultecti.customer.api.service.ICustomerService;
import com.consultecti.customer.api.service.IDistributorService;
import com.consultecti.customer.api.util.RouterUtil;
import com.consultecti.customer.api.util.ValidatorUtil;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@RestController
@RequestMapping(value = RouterUtil.ROOT)
public class CustomerController {
	
	private ICustomerService customerService;
	private IDistributorService distributorService;
	private ModelMapper modelMapperDto;
	private final Type listType = new TypeToken<List<CustomerDto>>(){}.getType();
	private final String INVALID_CUSTOMERID = "Invalid CustomerId %s";
	
	/**
	 * 
	 */
	@Autowired
	public CustomerController(final ICustomerService customerService, final IDistributorService distributorService, final ModelMapper modelMapperDto) {
		this.customerService = customerService;
		this.distributorService = distributorService;
		this.modelMapperDto = modelMapperDto;
	}
	
	@GetMapping(value = RouterUtil.CUSTOMERS, produces = RouterUtil.PRODUCES)
	protected ResponseEntity<Object> findAll() {
		
		List<CustomerDto> customers = this.
				modelMapperDto.map(
						this.customerService
						.findAll(), 
						listType);
		
		return new ResponseEntity<>(
				customers, 
				HttpStatus.OK);
	}
	
	@PostMapping(value = RouterUtil.CUSTOMERS_ADD, produces = RouterUtil.PRODUCES)
	protected ResponseEntity<Object> add(@Valid final @RequestBody AddCustomerRequest customerRequest, final BindingResult validator) {
		
		/**
		 * Validate the request data
		 */
		if (validator.hasErrors())
			return new ResponseEntity<Object>(ValidatorUtil.getValidationError(validator),
					HttpStatus.BAD_REQUEST);
		
		/**
		 * All users are created by default under the ENABLED status and under the distributorId = 1
		 */
		Customer customer = new Customer(
				customerRequest.getName(), 
				customerRequest.getLastName(), 
				customerRequest.getUsername(), 
				customerRequest.getPassword(), 
				customerRequest.getEmail(), 
				customerRequest.getAddress(), 
				CustomerStatus.ENABLED, 
				this.distributorService.findById(1L));
		
		customer = this.customerService.add(customer);
		
		return new ResponseEntity<>(
				this.modelMapperDto.map(
						customer, 
						CustomerDto.class), 
				HttpStatus.OK);
	}
	
	@PutMapping(value = RouterUtil.CUSTOMERS_UPDATE, produces = RouterUtil.PRODUCES)
	protected ResponseEntity<Object> update(@Valid final @RequestBody UpdateCustomerRequest customerRequest, final BindingResult validator) {
		
		/**
		 * Validate the request data
		 */
		if (validator.hasErrors())
			return new ResponseEntity<Object>(ValidatorUtil.getValidationError(validator),
					HttpStatus.BAD_REQUEST);
		
		/**
		 * Get the current Customer for this customerId and set all new data for update
		 */
		Customer customer = this.customerService.findById(customerRequest.getId());
		
		if(customer != null) {			
			customer.setName(customerRequest.getName());
			customer.setLastName(customerRequest.getLastName());
			customer.setUsername(customerRequest.getUsername());
			customer.setPassword(customerRequest.getPassword());
			customer.setStatus(customerRequest.getCustomerStatus());
			customer.setAddress(customerRequest.getAddress());
			customer.setEmail(customerRequest.getEmail());
			
			customer = this.customerService.update(customer);
			
			return new ResponseEntity<>(
					this.modelMapperDto.map(
							customer, 
							CustomerDto.class), 
					HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(
				String.format(INVALID_CUSTOMERID, customerRequest.getId()),
				HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value = RouterUtil.CUSTOMERS_DELETE, produces = RouterUtil.PRODUCES)
	protected ResponseEntity<Object> delete(final @PathVariable(name = "customerId", required = true) Long customerId) {
		
		Customer customer = this.customerService.findById(customerId);
		
		if(customer != null) {
			this.customerService.delete(customerId);
			return new ResponseEntity<>(
					this.modelMapperDto.map(
							customer, 
							CustomerDto.class), 
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(
				String.format(INVALID_CUSTOMERID, customerId),
				HttpStatus.BAD_REQUEST);
		
	}
}
