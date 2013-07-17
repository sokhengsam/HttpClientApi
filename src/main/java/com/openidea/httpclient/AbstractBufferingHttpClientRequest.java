/**
 * 
 */
package com.openidea.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author sokheng
 *
 */
public abstract class AbstractBufferingHttpClientRequest implements HttpClientRequest {
	
	private HttpHeader headers = new HttpHeader();
	
	private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpMessage#getHttpHeader()
	 */
	@Override
	public HttpHeader getHttpHeader() {
		return this.headers;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientRequest#getBody()
	 */
	@Override
	public OutputStream getBody() {
		return buffer;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientRequest#execute()
	 */
	@Override
	public HttpClientResponse execute() throws IOException {
		// TODO Auto-generated method stub
		HttpClientResponse httpCiClientResponse = executeClientRequest(getHttpHeader(),getBody());
		return httpCiClientResponse;
	}
	
	public abstract HttpClientResponse executeClientRequest(HttpHeader header,OutputStream buffer) throws IOException;

}
