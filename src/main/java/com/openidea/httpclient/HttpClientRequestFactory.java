package com.openidea.httpclient;
import java.net.URI;


/**
 * 
 */

/**
 * @author sokheng
 *
 */
public interface HttpClientRequestFactory {

	HttpClientRequest createRequest(URI uri,HttpMethod method);
	
}
