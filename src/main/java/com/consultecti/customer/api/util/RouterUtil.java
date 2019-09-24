/**
 * 
 */
package com.consultecti.customer.api.util;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
public final class RouterUtil {
	
	/**
	 * Api routers.
	 */
	public static final String ROOT = "/api/v1/customers/";
	public static final String CUSTOMERS = "list";
	public static final String CUSTOMERS_ADD = "add";
	public static final String CUSTOMERS_UPDATE = "update";
	public static final String CUSTOMERS_DELETE = "delete/{customerId}";
	public static final String CUSTOMERS_BY_USERNAME = "by/username/{username}";
	public static final String CUSTOMERS_BY_STATUS = "by/status/{status}";
	
	public final static String PRODUCES = "application/json; charset=utf-8";
}
