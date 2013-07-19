/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 * @author sokheng
 *
 */
public class HttpCommonHttpClientResponse implements HttpClientResponse {

	
	private final HttpResponse httpResponse;
	

	public HttpCommonHttpClientResponse(HttpResponse httpResponse) {
		this.httpResponse = httpResponse;
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
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientResponse#getBody()
	 */
	@Override
	public InputStream getBody() throws IllegalStateException, IOException {
		final HttpEntity httpEntity = getHttpResponse().getEntity();
		return httpEntity != null ? httpEntity.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientResponse#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the httpResponse
	 */
	public HttpResponse getHttpResponse() {
		return httpResponse;
	}
}
