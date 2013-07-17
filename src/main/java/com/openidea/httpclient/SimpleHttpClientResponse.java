/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * @author sokheng
 *
 */
public class SimpleHttpClientResponse implements HttpClientResponse {
	
	private HttpURLConnection connection;
	
	public SimpleHttpClientResponse(HttpURLConnection connection){
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpMessage#getHttpHeader()
	 */
	@Override
	public HttpHeader getHttpHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientResponse#getStatusCode()
	 */
	@Override
	public HttpStatus getStatusCode() throws IOException {
		return HttpStatus.valueOf(this.connection.getResponseCode());
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientResponse#getBody()
	 */
	@Override
	public InputStream getBody() throws IOException {
		final InputStream errorInputStream = this.connection.getErrorStream();
		return errorInputStream != null ? errorInputStream : this.connection.getInputStream();
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientResponse#close()
	 */
	@Override
	public void close() {
		this.connection.disconnect();

	}

}
