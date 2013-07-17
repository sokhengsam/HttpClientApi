/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author sokheng
 *
 */
public interface HttpClientRequest extends HttpMessage {
	
	OutputStream getBody();
	
	HttpClientResponse execute() throws IOException;
	
}
