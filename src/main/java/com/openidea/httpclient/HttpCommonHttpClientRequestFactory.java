/**
 * 
 */
package com.openidea.httpclient;

import java.net.URI;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.CoreConnectionPNames;

/**
 * @author sokheng
 *
 */
public class HttpCommonHttpClientRequestFactory implements HttpClientRequestFactory {

	public static int 	DEFAULT_MAX_TOTAL_CONNECTION = 100;
	
	public static int DEFAULT_TIMEOUT_CONNECTION = 60*1000;
	
	public static int DEFAULT_MAX_CONNECTION_PER_ROUT = 5;
	
	private HttpClient httpClient;
	
	/**
	 * @return the httpClient
	 */
	public HttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * @param httpClient the httpClient to set
	 */
	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public HttpCommonHttpClientRequestFactory(){
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
		ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(schemeRegistry);
		threadSafeClientConnManager.setMaxTotal(DEFAULT_MAX_TOTAL_CONNECTION);
		threadSafeClientConnManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTION_PER_ROUT);
		httpClient = new DefaultHttpClient(threadSafeClientConnManager);
		getHttpClient().getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, DEFAULT_TIMEOUT_CONNECTION);
	}
	
	/**
	 * 
	 * @param timeout
	 */
	public void setConnectionTimeout(int timeout){
		getHttpClient().getParams().getLongParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
	}
	
	/* (non-Javadoc
	 * @see com.openidea.httpclient.HttpClientRequestFactory#createRequest(java.net.URI, com.openidea.httpclient.HttpMethod)
	 */
	@Override
	public HttpClientRequest createRequest(URI uri, HttpMethod method) {
		final HttpUriRequest httpUriRequest = createRequestMethod(uri, method);
		return new HttpCommonBufferingHttpClientRequest(getHttpClient(),httpUriRequest);
	}
	
	protected HttpUriRequest createRequestMethod(URI uri,HttpMethod method){
		switch (method) {
		case GET:
			return new HttpGet(uri);
		case POST:
			return new HttpPost(uri);
		case PUT: 
			return new HttpPut(uri);
		case OPTION:
			return new HttpOptions(uri);
		case HEADER:
			return new HttpHead(uri);
		default:
			throw new IllegalArgumentException("Unsupport request method" + method);
		}
		
	}


}
