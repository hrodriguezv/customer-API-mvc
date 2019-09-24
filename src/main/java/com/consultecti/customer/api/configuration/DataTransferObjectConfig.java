/**
 * 
 */
package com.consultecti.customer.api.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Configuration
public class DataTransferObjectConfig {
	
	@Bean
    public ModelMapper modelMapperDto() {
        return new ModelMapper();
    }
}
