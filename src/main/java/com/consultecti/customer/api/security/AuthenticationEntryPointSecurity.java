/**
 * 
 */
package com.consultecti.customer.api.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import net.minidev.json.JSONObject;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
public class AuthenticationEntryPointSecurity extends BasicAuthenticationEntryPoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.www.
	 * BasicAuthenticationEntryPoint#commence(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		
		JSONObject json = new JSONObject();
	    try {
			json.put("HTTP Status: ", response.getStatus());
			json.put("Message", authException.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    writer.print(json.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.www.
	 * BasicAuthenticationEntryPoint#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName(SecurityConfigurationSecurity.REALM);
		super.afterPropertiesSet();
	}
}
