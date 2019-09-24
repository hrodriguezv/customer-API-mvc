package com.consultecti.customer.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.consultecti.customer.api.model.domain.Customer;
import com.consultecti.customer.api.model.domain.CustomerStatus;
import com.consultecti.customer.api.model.domain.Distributor;
import com.consultecti.customer.api.service.ICustomerService;
import com.consultecti.customer.api.service.IDistributorService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerApiApplicationTests {

	@Autowired
	private IDistributorService distributorService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Test
	void test() {

		//CREATE A Distributor
		Distributor distributor = this.distributorService.add(new 
				Distributor("Show Room Luxery Republica Dominica", 
							"repdomshowluxery@domain.com.do", 
							"Ave. Nunez de Caceres #289 D.N, Rep. Dom"));
		assertThat(distributor.getId() > 0L);
		
		
		//TEST THE INIT DATA IN DB
		assertThat(customerService.findById(1L).getName()).isEqualTo("Jose");
		
		//CREATE A Customer
		Customer customer = this.customerService.add(new 
				Customer("Diano Mars", "Castro Tull", "diotull", 
						"849hr2d", "diotull@gmail.com", "C/Francisco Matia Mella #465, San Cristobal, Rep. Dom.", 
						CustomerStatus.DISABLED, distributor));
		
		assertThat(customer.getId() > 0L);

		assertThat(customer.getId()).isEqualTo(4L);
		
		assertThat(customerService.findById(customer.getId()).getDistributor().getId()).isEqualTo(distributor.getId());
	}

}
