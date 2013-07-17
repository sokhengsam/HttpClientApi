/**
 * 
 */
package com.openidea.httpclient;

/**
 * @author sokheng
 * 
 */
public enum HttpStatus {
	OK(200, "OK");
	
	private final int value;
	private final String description;

	private HttpStatus(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	/**
	 * 
	 * @return
	 */
	public int value(){
		return this.value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public static HttpStatus valueOf(int value){
		for(HttpStatus status : values()){
			if(value == status.value){
				return status;
			}
		}
		throw new IllegalArgumentException("");
	}
	
}
