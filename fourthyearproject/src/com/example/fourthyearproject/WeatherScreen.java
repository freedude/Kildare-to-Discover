/**
 * @author Seán Freeman <seanfreemantya@gmail.com> Sourced by tutorial:
 * @version 1.0
 * 
 * Creates an interface that displays the parsed weather information to the user.An Asynchronous task does all the weather
 * processing, including connecting to the API, and setting the information into a weather object. This weather object
 * is then parsed and Each textView set up takes an instance of this object to display the corresponding weather information.
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String city name to determine what position the weather information should be taken from
 * @param  Weather object to be used to display different parts of information from it in textViews
 * @return      Numerous textViews displaying live weather conditions for the city provided on its own interface.
 * @see         WeatherScreen
 */

package com.example.fourthyearproject;

import org.json.JSONException;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherScreen extends Activity {

	private TextView cityText, condDescr, temp, press, windSpeed, hum, maxTemp, minTemp, clouds, pressLab, humLab, windLab;
	private ImageView imgView; //not working

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weatheractivity);
		String city = "Donadea, Kildare";
		
		cityText = (TextView) findViewById(R.id.cityText);
		condDescr = (TextView) findViewById(R.id.condDescr);
		temp = (TextView) findViewById(R.id.temp);
		hum = (TextView) findViewById(R.id.hum);
		press = (TextView) findViewById(R.id.press);
		windSpeed = (TextView) findViewById(R.id.windSpeed);
		maxTemp = (TextView) findViewById(R.id.maxTemp);
		minTemp= (TextView) findViewById(R.id.minTemp);
		clouds = (TextView) findViewById(R.id.clouds);
		pressLab = (TextView) findViewById(R.id.pressLab);
		humLab = (TextView) findViewById(R.id.humLab);
		windLab = (TextView) findViewById(R.id.windLab);
		
		imgView = (ImageView) findViewById(R.id.condIcon); //nope
		
		//Set font
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");
		cityText.setTypeface(tf1); condDescr.setTypeface(tf1); temp.setTypeface(tf1); hum.setTypeface(tf1);
		press.setTypeface(tf1); windSpeed.setTypeface(tf1); maxTemp.setTypeface(tf1);
		minTemp.setTypeface(tf1); clouds.setTypeface(tf1); pressLab.setTypeface(tf1);
		humLab.setTypeface(tf1);windLab.setTypeface(tf1);
		
		cityText.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		

		JSONWeatherTask task = new JSONWeatherTask();
		task.execute(new String[]{city});
	}

	private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {
		@Override
		protected Weather doInBackground(String... params) { 
			Weather weather = new Weather();
			String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

			try {
				weather = JSONWeatherParser.getWeather(data);
//				// Retrieve the icon
//				weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon())); //not working
			} catch (JSONException e) {				
				e.printStackTrace();
			}
			return weather;	
		}
		@Override
		protected void onPostExecute(Weather weather) {			
			super.onPostExecute(weather);

			if (weather.iconData != null && weather.iconData.length > 0) {
				Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length); 
				imgView.setImageBitmap(img);
			} //icons not working

			cityText.setText(weather.location.getCity() + ", " + weather.location.getCountry());
			condDescr.setText(weather.currentCondition.getCondition() + " (" + weather.currentCondition.getDescr() + ")");
			temp.setText("Temperature: " + Math.round((weather.temperature.getTemp() - 273.15)) + "c");
			hum.setText("" + weather.currentCondition.getHumidity() + "%");
			press.setText("" + weather.currentCondition.getPressure() + " hPa");
			windSpeed.setText("" + weather.wind.getSpeed() + " M/ps");
			maxTemp.setText("Max Temp: " + Math.round((+ weather.temperature.getMaxTemp() - 273.15)) + "c");
			minTemp.setText("Min Temp: " + Math.round((+ weather.temperature.getMinTemp() - 273.15)) + "c");
			clouds.setText("Clouds: " + weather.clouds.getPerc()+ "%");
			
		}
	}
}