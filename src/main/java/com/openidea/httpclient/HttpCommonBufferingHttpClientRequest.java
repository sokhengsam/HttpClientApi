/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * @author sokheng
 *
 */
public class HttpCommonBufferingHttpClientRequest extends
		AbstractBufferingHttpClientRequest {
	
	private final HttpClient httpClient;
	
	private final HttpUriRequest httpUriRequest;
	

	public HttpCommonBufferingHttpClientRequest(HttpClient httpClient,HttpUriRequest httpUriRequest) {
		this.httpClient = httpClient;
		this.httpUriRequest = httpUriRequest;
	}

	/**
	 * @return the httpClient
	 */
	public HttpClient getHttpClient() {
		return httpClient;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.BufferingHttpClientRequest#executeClientRequest()
	 */
	@Override
	public HttpClientResponse executeClientRequest(HttpHeader header,OutputStream buffer) throws ClientProtocolException, IOException {
		final HttpResponse httpResponse = getHttpClient().execute(getHttpUriRequest());
		return new HttpCommonHttpClientResponse(httpResponse);
	}

	/**
	 * @return the httpUriRequest
	 */
	public HttpUriRequest getHttpUriRequest() {
		return httpUriRequest;
	}

}
