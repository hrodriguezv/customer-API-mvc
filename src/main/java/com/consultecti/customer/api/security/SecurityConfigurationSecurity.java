/**
 * 
 */
package com.consultecti.customer.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.consultecti.customer.api.configuration.AuthenticationConfig;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurationSecurity extends WebSecurityConfigurerAdapter {

	public static final String REALM = "Customer Information Management | Rest Api";

	@Autowired
	private AuthenticationConfig authConfig;
	
	private static final String MATCHERS = "/api/**";
	
	private static final String[] AUTH_WHITELIST = {"/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs",
			"/webjars/**", "/swagger.json"};
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser(authConfig.getUsername())
			.password(passwordEncoder()
					.encode(authConfig.getPassword()))
			.roles(authConfig.getRole());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(AUTH_WHITELIST).permitAll()
			.antMatchers(MATCHERS)
			.hasRole(authConfig.getRole())
			.and()
			.httpBasic()
			.realmName(REALM)
			.authenticationEntryPoint(getBasicAuthEntryPoint())
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)// We don't need sessions to be created.
			.and()
			.csrf().disable();
	}
	
	@Bean
    public AuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new AuthenticationEntryPointSecurity();
    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.WebSecurity)
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}
}
