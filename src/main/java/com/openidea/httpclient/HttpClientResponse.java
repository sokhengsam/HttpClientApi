/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sokheng
 *
 */
public interface HttpClientResponse extends HttpMessage {

	HttpStatus getStatusCode() throws IOException;
	
	InputStream getBody() throws IOException;
	
	void close();
	
}
