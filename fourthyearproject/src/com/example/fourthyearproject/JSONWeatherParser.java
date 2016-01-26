/**
 * @author Seán Freeman <seanfreemantya@gmail.com> Sourced by tutorial:
 * @version 1.0
 * 
 * This class forms another part of the RESTful web service. It creates a JSONobject and from location data received in 
 * Http GET, it extracts the particular weather details and parses the response into a WeatherLocation object. The JSONobject
 * is used to fill a JSONArray with information from the openweathermap API based on each of its tags.
 * 
 * @param  
 * @param  String data entered into numerous JSON Objects to retrieve information based on openweathermap tags
 * @return      Parsed JSON information from openweathermap tags to be displayed in textviews in WeatherScreen class.
 * @see         JSONWeatherParser
 */
package com.example.fourthyearproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.fourthyearproject.WeatherLocation;
import com.example.fourthyearproject.Weather;

public class JSONWeatherParser {

	public static Weather getWeather(String data) throws JSONException  {
		Weather weather = new Weather();

		// Create a JSONObject from the data. This is for the location
		JSONObject jObj = new JSONObject(data);
		
		// Extract the info and parse response
		WeatherLocation loc = new WeatherLocation();
		
		JSONObject coordObj = getObject("coord", jObj);
		loc.setLatitude(getFloat("lat", coordObj));
		loc.setLongitude(getFloat("lon", coordObj));
		
		JSONObject sysObj = getObject("sys", jObj);
		loc.setCountry(getString("country", sysObj));
		
		loc.setCity(getString("name", jObj));
		weather.location = loc; //loc object now contains all this information
		
		// Retrieves weather information in an array
		JSONArray jArr = jObj.getJSONArray("weather");
		
		// Current condition
		JSONObject JSONWeather = jArr.getJSONObject(0);
		weather.currentCondition.setWeatherId(getInt("id", JSONWeather));
		weather.currentCondition.setDescr(getString("description", JSONWeather));
		weather.currentCondition.setCondition(getString("main", JSONWeather));
		
		//Humidity, pressure and temperature
		JSONObject mainObj = getObject("main", jObj);
		weather.currentCondition.setHumidity(getInt("humidity", mainObj));
		weather.currentCondition.setPressure(getInt("pressure", mainObj));
		weather.temperature.setMaxTemp(getFloat("temp_max", mainObj)); 
		weather.temperature.setMinTemp(getFloat("temp_min", mainObj));
		weather.temperature.setTemp(getFloat("temp", mainObj));
		
		// Wind
		JSONObject wObj = getObject("wind", jObj);
		weather.wind.setSpeed(getFloat("speed", wObj));
		weather.wind.setDeg(getFloat("deg", wObj));
		
		// Clouds
		JSONObject cObj = getObject("clouds", jObj); 
		weather.clouds.setPerc(getInt("all", cObj));
	
		return weather;
	}
	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
		JSONObject subObj = jObj.getJSONObject(tagName);
		return subObj;
	}
	private static String getString(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getString(tagName);
	}
	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
		return (float) jObj.getDouble(tagName);
	}
	private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getInt(tagName);
	}
}