/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2016 Rui Gong
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.alberteinstein29.indeed4j.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.github.alberteinstein29.indeed4j.fragments.UserAgent;

public class HttpClient {

	private final String url;
    private final UserAgent userAgent;

    public HttpClient(String url, UserAgent userAgent) throws MalformedURLException {
		
		this.url = url;
		this.userAgent = userAgent;
	}
    
    /**
     * Sends out the GET request.
     * @return the result
     * @throws IOException
     * @throws InterruptedException
     * @throws ExecutionException
     */
	public String getResponse()
			throws IOException, InterruptedException, ExecutionException {

		return CompletableFuture
				.supplyAsync(() -> sendGET()).get();
	}

	/**
	 * Sends out the GET request.
	 * 
	 * @return response from server
	 */
	private String sendGET() {
		
		RequestConfig globalConfig = null;
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null;
		BufferedReader reader = null;
		StringBuffer response = new StringBuffer();
		String inputLine;
		
		try {
			/*
			 * Ignores the cookie warning by setting the cookie policy.
			 * https://hc.apache.org/httpcomponents-client-ga/tutorial/html/statemgmt.html
			 */
			globalConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();

			httpClient = HttpClients.custom()
					.setDefaultRequestConfig(globalConfig).build();

			httpGet = new HttpGet(url);
			httpGet.addHeader("User-Agent", userAgent.getUserAgent());
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			reader = new BufferedReader(new InputStreamReader(httpResponse
					.getEntity().getContent()));

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

			reader.close();
			httpClient.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}
}
