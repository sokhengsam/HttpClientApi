/**
 * 
 */
package com.openidea.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * @author sokheng
 *
 */
public abstract class BufferingHttpClientRequest implements HttpClientRequest {
	
	private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpMessage#getHttpHeader()
	 */
	@Override
	public HttpHeader getHttpHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientRequest#getBody()
	 */
	@Override
	public OutputStream getBody() {
		// TODO Auto-generated method stub
		return buffer;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientRequest#execute()
	 */
	@Override
	public HttpClientResponse execute() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract HttpClientResponse executeClientRequest();

}
