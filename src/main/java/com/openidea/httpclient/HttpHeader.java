/**
 * 
 */
package com.openidea.httpclient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sokheng
 * 
 */
public class HttpHeader {

	private Map<String, String> headers = new HashMap<String, String>();

	public void add(final String headerName, final String headerValue) {
		if(!isExistHeader(headerName)){
			this.headers.put(headerName, headerValue);
		}
	}

	/**
	 * Check header is exiting in the header map
	 * 
	 * @param headerName
	 *            String of header
	 * @return boolean exiting or not exist
	 */
	protected boolean isExistHeader(final String headerName) {
		return this.headers.get(headerName) != null;
	}

}
