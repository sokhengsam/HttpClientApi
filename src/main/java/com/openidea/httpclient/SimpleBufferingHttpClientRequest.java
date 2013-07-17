/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * @author sokheng
 *
 */
public class SimpleBufferingHttpClientRequest extends
		AbstractBufferingHttpClientRequest {

	private final HttpURLConnection connection;

	public SimpleBufferingHttpClientRequest(HttpURLConnection connection){
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see com.openidea.httpclient.BufferingHttpClientRequest#executeClientRequest()
	 */
	@Override
	public HttpClientResponse executeClientRequest(HttpHeader header,OutputStream buffer) throws IOException {
		// add header to connection
		this.connection.connect();
		return new SimpleHttpClientResponse(this.connection);
	}

}
