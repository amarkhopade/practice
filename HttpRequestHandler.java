package com.tcs.ilp.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpRequestHandler {

	public String executeRequestCreateDataSource(String API_URL, String jsonRequestBody, String accessToken) {
		String jsonResponse = "";
		try {

			System.out.println("Going to send request");
			URL url = new URL(API_URL);

			System.out.println(API_URL);

			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
			// "proxy.tcs.com", 8080));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			System.out.println("Conn opened");
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("GoogleAuthz", "Bearer " + accessToken);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			OutputStream os = conn.getOutputStream();

			os.write(jsonRequestBody.getBytes());
			os.flush();
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(
						"Failed : HTTP error code : " + conn.getResponseCode() + conn.getResponseMessage());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {
				jsonResponse += output;
			}

			System.out.println(jsonResponse);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return jsonResponse;
	}

	public String executeRequestCreateDataSet(String API_URL, String jsonRequestBody, String accessToken)
			throws URISyntaxException {
		String jsonResponse = "";
		try {

			System.out.println(API_URL);

			System.out.println("Going to send request");
			URL url = new URL(API_URL);

			// HttpClient httpClient = new DefaultHttpClient();
			// HttpPatch httpPatch = new HttpPatch();
			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
			// "proxy.tcs.com", 8080));
			/*
			 * HttpPost httpPost = new HttpPost(new URI("http://api.techjira.com/user/123"))
			 * {
			 * 
			 * @Override public String getMethod() { return "PATCH"; } };
			 */

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			System.out.println("Conn opened");
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("GoogleAuthz", "Bearer " + accessToken);
			conn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			System.out.println("I m here");

			OutputStream os = conn.getOutputStream();

			os.write(jsonRequestBody.getBytes());
			os.flush();
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(
						"Failed : HTTP error code : " + conn.getResponseCode() + conn.getResponseMessage());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {
				jsonResponse += output;
			}

			System.out.println(jsonResponse);

			conn.disconnect();

			/*
			 * StringEntity inputData = new StringEntity(jsonRequestBody);
			 * 
			 * 
			 * 
			 * HttpPost httpPost = new HttpPost(API_URL+"?_HttpMethod=PATCH");
			 * 
			 * httpPost.setEntity(inputData); httpPost.addHeader("Content-Type",
			 * "application/json"); httpPost.addHeader("Authorization", "Bearer " +
			 * accessToken); httpPost.addHeader("GoogleAuthz", "Bearer " + accessToken);
			 * 
			 * HttpClient httpClient = new DefaultHttpClient(); HttpResponse response =
			 * httpClient.execute(httpPost);
			 */
			// System.out.println(response);

			// HttpEntity jsonResponse = response.getEntity();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return jsonResponse;
	}

	public String generateAccessToken(String API_URL, String jsonRequestBody, String accessToken)
			throws URISyntaxException {
		String jsonResponse = "";
		try {

			System.out.println(API_URL);

			System.out.println("Going to send request");
			URL url = new URL(API_URL);

			// HttpClient httpClient = new DefaultHttpClient();
			// HttpPatch httpPatch = new HttpPatch();
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.tcs.com", 8080));
			/*
			 * HttpPost httpPost = new HttpPost(new URI("http://api.techjira.com/user/123"))
			 * {
			 * 
			 * @Override public String getMethod() { return "PATCH"; } };
			 */

			HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);

			System.out.println("Conn opened");
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("GoogleAuthz", "Bearer " + accessToken);
			conn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			System.out.println("I m here");

			OutputStream os = conn.getOutputStream();

			os.write(jsonRequestBody.getBytes());
			os.flush();
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(
						"Failed : HTTP error code : " + conn.getResponseCode() + conn.getResponseMessage());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {
				jsonResponse += output;
			}

			System.out.println(jsonResponse);

			conn.disconnect();

			/*
			 * StringEntity inputData = new StringEntity(jsonRequestBody);
			 * 
			 * 
			 * 
			 * HttpPost httpPost = new HttpPost(API_URL+"?_HttpMethod=PATCH");
			 * 
			 * httpPost.setEntity(inputData); httpPost.addHeader("Content-Type",
			 * "application/json"); httpPost.addHeader("Authorization", "Bearer " +
			 * accessToken); httpPost.addHeader("GoogleAuthz", "Bearer " + accessToken);
			 * 
			 * HttpClient httpClient = new DefaultHttpClient(); HttpResponse response =
			 * httpClient.execute(httpPost);
			 */
			// System.out.println(response);

			// HttpEntity jsonResponse = response.getEntity();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return jsonResponse;
	}

	public String executeRequestCreateSessions(String API_URL, String jsonRequestBody, String accessToken) {
		String jsonResponse = "";
		try {

			System.out.println("API URL" + API_URL);

			System.out.println("Going to send request");
			URL url = new URL(API_URL);

			// HttpClient httpClient = new DefaultHttpClient();
			// HttpPatch httpPatch = new HttpPatch();
			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
			// "proxy.tcs.com", 8080));
			/*
			 * HttpPost httpPost = new HttpPost(new URI("http://api.techjira.com/user/123"))
			 * {
			 * 
			 * @Override public String getMethod() { return "PATCH"; } };
			 */

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			System.out.println("Conn opened");
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("GoogleAuthz", "Bearer " + accessToken);
			conn.setRequestProperty("X-HTTP-Method-Override", "PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			System.out.println("I m here");

			OutputStream os = conn.getOutputStream();

			os.write(jsonRequestBody.getBytes());
			os.flush();
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(
						"Failed : HTTP error code : " + conn.getResponseCode() + conn.getResponseMessage());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {
				jsonResponse += output;
			}

			System.out.println(jsonResponse);

			conn.disconnect();

			/*
			 * StringEntity inputData = new StringEntity(jsonRequestBody);
			 * 
			 * 
			 * 
			 * HttpPost httpPost = new HttpPost(API_URL+"?_HttpMethod=PATCH");
			 * 
			 * httpPost.setEntity(inputData); httpPost.addHeader("Content-Type",
			 * "application/json"); httpPost.addHeader("Authorization", "Bearer " +
			 * accessToken); httpPost.addHeader("GoogleAuthz", "Bearer " + accessToken);
			 * 
			 * HttpClient httpClient = new DefaultHttpClient(); HttpResponse response =
			 * httpClient.execute(httpPost);
			 */
			// System.out.println(response);

			// HttpEntity jsonResponse = response.getEntity();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return jsonResponse;
	}

	public String executeRequestGetDataSource(String url, String access_token) {
		String dataStreamId = "";

		return dataStreamId;
	}

}
