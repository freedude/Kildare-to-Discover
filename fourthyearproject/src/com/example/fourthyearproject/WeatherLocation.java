/**
 * @author Seán Freeman <seanfreemantya@gmail.com> Sourced by tutorial:
 * @version 1.0
 * 
 * This class sets up float attributes to declare the longitude and lattitude, and 2 strings for the country and city names.
 * It declares all Get and Set methods for the locations position to be used in WeatherScreen class.
 * 
 * @param  float lattitude for retaining the locations lattitude number
 * @param  float lattitude for retaining the locations longitude number
 * @param  String country to retain the name of the country the weather is happening in
 * @param  String city to retain the name of the city the weather is happening in
 * @return      Lattitude/Longitude/City/Country/Sunset/Sunrise values to be parsed and displayed in further classes.
 * @see         WeatherLocation
 */

package com.example.fourthyearproject;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WeatherLocation implements Serializable{

	//Variable for position, city, and country
	private float longitude;
	private float latitude;
	private String country;
	private String city;
	
	//Location Getters and Setters for position, city, and country
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
}