/**
 * @author Seán Freeman <seanfreemantya@gmail.com> Sourced by tutorial:
 * @version 1.0
 * 
 * This class sets up objects for getting and setting current condition, temperature, wind, rain, snow and clouds details
 * based on the location provided from a WeatherLocation object
 * 
 * @param  location for determining weather conditions based on provided location
 * @param  float values for temperature, wind, rain and snow
 * @param  int value for clouds
 * @param  String for the amount of the time the rain/snow has been falling
 * @param  String country to retain the name of the country the weather is happening in
 * @param  String city to retain the name of the city the weather is happening in
 * @return Current Condition/Pressure/Humidity/Temperature/Wind speed + direction/Clouds values to be parsed and
 * 		   displayed in further classes.
 * @see    Weather
 */

package com.example.fourthyearproject;

public class Weather {

	public WeatherLocation location;
	public CurrentCondition currentCondition = new CurrentCondition();
	public Temperature temperature = new Temperature();
	public Wind wind = new Wind();
	public Rain rain = new Rain();
	public Snow snow = new Snow()	;
	public Clouds clouds = new Clouds();

	public byte[] iconData; //not working

	public class CurrentCondition {
		private int weatherId;
		private String condition;
		private String descr;
		private String icon; 

		private float pressure;
		private float humidity;

		// Weather Getters and Setters
		public int getWeatherId() {
			return weatherId;
		}
		public void setWeatherId(int weatherId) {
			this.weatherId = weatherId;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		public String getIcon() { 
			return icon;
		}
		public void setIcon(String icon) { 
			this.icon = icon;
		}
		public float getPressure() {
			return pressure;
		}
		public void setPressure(float pressure) {
			this.pressure = pressure;
		}
		public float getHumidity() {
			return humidity;
		}
		public void setHumidity(float humidity) {
			this.humidity = humidity;
		}
	}
	public class Temperature {
		private float temp;
		private float minTemp; 
		private float maxTemp; 

		//Temperature getters and setters
		public float getTemp() {
			return temp;
		}
		public void setTemp(float temp) {
			this.temp = temp;
		}
		public float getMinTemp() { 
			return minTemp;
		}
		public void setMinTemp(float minTemp) { 
			this.minTemp = minTemp;
		}
		public float getMaxTemp() { 
			return maxTemp;
		}
		public void setMaxTemp(float maxTemp) { 
			this.maxTemp = maxTemp;
		}
	}
	public class Wind {
		private float speed;
		private float deg;
		
		//Wind getters + setters
		public float getSpeed() {
			return speed;	
		}
		public void setSpeed(float speed) {
			this.speed = speed;
		}
		public float getDeg() {
			return deg;
		}
		public void setDeg(float deg) {
			this.deg = deg;
		}
	}
	public class Rain {
		private String time;
		private float ammount;
		
		//Rain getters + setters
		public String getTime() { 
			return time;
		}
		public void setTime(String time) { 
			this.time = time;
		}
		public float getAmmount() {
			return ammount;
		}
		public void setAmmount(float ammount) {
			this.ammount = ammount;
		}
	}
	public class Snow {
		private String time;
		private float ammount;

		//Snow getters + setters
		public String getTime() { 
			return time; 
		}
		public void setTime(String time) { 
			this.time = time;
		}
		public float getAmmount() {
			return ammount;
		}
		public void setAmmount(float ammount) {
			this.ammount = ammount;
		}
	}
	public class Clouds { 
		private int perc;
		//Cloud getters + setters
		public int getPerc() {
			return perc;
		}
		public void setPerc(int perc) {
			this.perc = perc;
		}
	}
}