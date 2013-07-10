/**
 * 
 */
package com.openidea.httpclient;

import java.io.InputStream;

/**
 * @author sokheng
 *
 */
public interface HttpClientResponse extends HttpMessage {

	HttpStatus getStatusCode();
	
	InputStream getBody();
	
	void close();
	
}
