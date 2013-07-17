package com.openidea.httpclient;
import java.io.IOException;
import java.net.URI;


/**
 * 
 */

/**
 * @author sokheng
 *
 */
public interface HttpClientRequestFactory {

	HttpClientRequest createRequest(URI uri,HttpMethod method) throws IOException;
	
}
