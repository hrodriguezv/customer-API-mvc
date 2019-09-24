/**
 * 
 */
package com.consultecti.customer.api.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultecti.customer.api.controller.transfer.CustomerDto;
import com.consultecti.customer.api.model.domain.CustomerStatus;
import com.consultecti.customer.api.service.ICustomerService;
import com.consultecti.customer.api.util.RouterUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@ApiResponses(value = {
		@ApiResponse(code = 200, message = RouterUtil.HTTP_200),			
		@ApiResponse(code = 400, message = RouterUtil.HTTP_400),
		@ApiResponse(code = 500, message = RouterUtil.HTTP_500)})

@RestController
@RequestMapping(value = RouterUtil.ROOT)
public class CustomerSearchController {

	private ICustomerService customerService;
	private ModelMapper modelMapperDto;
	private final Type listType = new TypeToken<List<CustomerDto>>(){}.getType();
	
	/**
	 * 
	 */
	@Autowired
	public CustomerSearchController(final ICustomerService customerService,  final ModelMapper modelMapperDto) {
		this.customerService = customerService;
		this.modelMapperDto = modelMapperDto;
	}
	
	@ApiOperation(value = "Get a list with all customer by username ignoring the distributor", response = List.class)
	@GetMapping(value = RouterUtil.CUSTOMERS_BY_USERNAME, produces = RouterUtil.PRODUCES)
	protected ResponseEntity<Object> findByUsername(final @PathVariable(name = "username", required = true) String username) {
		
			List<CustomerDto> customers = this.
					modelMapperDto.map(
							this.customerService
							.findByUsername(username), 
							listType);
			
			return new ResponseEntity<>(
					customers, 
					HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get a list with all customer by status ignoring the distributor", response = List.class)
	@GetMapping(value = RouterUtil.CUSTOMERS_BY_STATUS, produces = RouterUtil.PRODUCES)
	protected ResponseEntity<Object> findByStatus(final @PathVariable(name = "status", required = true) String status) {
		
		if(status.equalsIgnoreCase(CustomerStatus.ENABLED.toString()) || 
				status.equalsIgnoreCase(CustomerStatus.DISABLED.toString())) {
			
			List<CustomerDto> customers = this.
					modelMapperDto.map(
							this.customerService
							.findByStatus( 
									status.equalsIgnoreCase(CustomerStatus.ENABLED.toString()) 
									? CustomerStatus.ENABLED : CustomerStatus.DISABLED), 
							listType);
			
			return new ResponseEntity<>(
					customers, 
					HttpStatus.OK);
		}	
		return new ResponseEntity<>(
				String.format("Invalid Customer Status. Should be ENABLED or DISABLED", status), 
				HttpStatus.BAD_REQUEST);
	}
}
