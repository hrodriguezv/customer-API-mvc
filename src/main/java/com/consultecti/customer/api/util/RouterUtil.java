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
	
	/**
	 * Description for all response httpStatus
	 */
	public static final String HTTP_200 = "Is returned when the requested process is executed correctly.";
	public static final String HTTP_400 = "Is returned when the requested was not executed correctly or the request does not complete with the validation rules.";
	public static final String HTTP_500 = "Is returned when an internal system error occurs and the request could not be processed.";
}
