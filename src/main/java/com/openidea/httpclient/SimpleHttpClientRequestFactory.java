/**
 * 
 */
package com.openidea.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.sun.jndi.cosnaming.CNNameParser;

/**
 * @author sokheng
 *
 */
public class SimpleHttpClientRequestFactory implements HttpClientRequestFactory {

	private Proxy proxy;
	
	private int connectionTimeout = -1;
	
	private int readTimeout = -1;
	
	/**
	 * @return the proxy
	 */
	public Proxy getProxy() {
		return proxy;
	}

	/**
	 * @param proxy the proxy to set
	 */
	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	/**
	 * @return the connectionTimeout
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * @param connectionTimeout the connectionTimeout to set
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * @return the readTimeout
	 */
	public int getReadTimeout() {
		return readTimeout;
	}

	/**
	 * @param readTimeout the readTimeout to set
	 */
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	/* (non-Javadoc)
	 * @see com.openidea.httpclient.HttpClientRequestFactory#createRequest(java.net.URI, com.openidea.httpclient.HttpMethod)
	 */
	@Override
	public HttpClientRequest createRequest(URI uri, HttpMethod method) throws IOException {
		HttpURLConnection connection = openConnection(uri);
		prepareConnection(connection, method);
		return new SimpleBufferingHttpClientRequest(connection);
	}
	
	private HttpURLConnection openConnection(URI uri) throws IOException{
		final URL url = uri.toURL();
		URLConnection connection = this.proxy != null ? url.openConnection(this.proxy) : url.openConnection();
		return (HttpURLConnection) connection;
	}

	private void prepareConnection(HttpURLConnection connection,HttpMethod method){
		if(getReadTimeout() > 0){
			connection.setReadTimeout(getReadTimeout());
		}
		if(getConnectionTimeout() > 0){
			connection.setConnectTimeout(getConnectionTimeout());
		}
		
		connection.setDoInput(true);
		if("GET".equals(method.name())){
			connection.setInstanceFollowRedirects(true);
		}
		else{
			connection.setInstanceFollowRedirects(false);
		}
		
		if("PUT".equals(method.name()) || "POST".equals(method.name())){
			connection.setDoOutput(true);
		}
		else{
			connection.setDoOutput(false);
		}
	}
	
}
