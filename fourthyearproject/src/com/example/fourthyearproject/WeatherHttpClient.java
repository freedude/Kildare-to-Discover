/**
 * @author Seán Freeman <seanfreemantya@gmail.com> Sourced by tutorial:
 * @version 1.0
 * 
 * This class is the core of the weather namespace. It establishes a Http connection to an openweathermap api liscenced with 
 * an application id declared in string.xml. Http GET method is used to retrieve weather information into a buffered reader and output
 * into a string buffer. The connection is then closed and data is past to the next classes for processing. This is a typical 
 * RESTful webservice created using REST architecture
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String location to determine what position to get the weather information at
 * @param  String url to connect to the API and retrieve its content based on the location string provided
 * @return      openweathermap data passed to a string buffer
 * @see         WeatherHttpClient
 */

package com.example.fourthyearproject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpClient {

	private static String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=06e4f4211c1651f7b91ee4ea9ccf17e8";  //"http://api.openweathermap.org/data/2.5/weather?q=";
	private static String IMG_URL = "http://openweathermap.org/img/w/10d.png"; 

	public String getWeatherData(String location) {
		HttpURLConnection con = null ;
		InputStream is = null;

		try {
			con = (HttpURLConnection) ( new URL(BASE_URL + location)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();

			// Read the response
			StringBuffer buffer = new StringBuffer();
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null)
				buffer.append(line + "\r\n"); //Carriage return and new line

			is.close();
			con.disconnect();
			return buffer.toString();
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
		finally {
			try { is.close(); } catch(Throwable t) {}
			try { con.disconnect(); } catch(Throwable t) {}
		}
		return null;
	}

	public byte[] getImage(String code) { 
		HttpURLConnection con = null ;
		InputStream is = null;
		try {
			con = (HttpURLConnection) ( new URL(IMG_URL + code)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();

			// Read the response
			is = con.getInputStream();
			byte[] buffer = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			while (is.read(buffer) != -1)
				baos.write(buffer);

			return baos.toByteArray();
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
		finally {
			try { is.close(); } catch(Throwable t) {}
			try { con.disconnect(); } catch(Throwable t) {}
		}
		return null;		
	}
}