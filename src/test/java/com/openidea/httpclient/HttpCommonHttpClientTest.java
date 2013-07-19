/**
 * 
 */
package com.openidea.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author sokheng
 *
 */
public class HttpCommonHttpClientTest {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws URISyntaxException, IOException {
	
		URI uri = new URI("http://feeds.bbci.co.uk/news/technology/rss.xml");
		
		HttpClientRequestFactory httpClientRequestFactory = new HttpCommonHttpClientRequestFactory();
		HttpClientRequest httpClientRequest = httpClientRequestFactory.createRequest(uri, HttpMethod.GET);
		HttpClientResponse httpClientResponse = httpClientRequest.execute();
		
		InputStreamReader inputStreamReader = new InputStreamReader(httpClientResponse.getBody());
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		String line;
		while((line = bufferReader.readLine()) != null){
			System.out.println(line);
		}
	}

}
