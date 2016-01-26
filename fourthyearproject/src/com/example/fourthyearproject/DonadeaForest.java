/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * 
 * Returns a layout file detailing information for the Riverbank Arts Centre. 
 * It creates an SQLiteDatabase table, inserts information into it, and selects the info to be displayed using
 * SQL queries. This produces the name of the location and a blurb on the type of place it is.
 * Opening Hours are displayed to the user, and live time is taken from the user's device to tell them if the place is currently open
 * or not. This Class also has a button press option for retrieving live
 * weather for the location due to it's outdoor nature. This functionality is described in the weather namespace(Weather classes)
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String object to declare a date to be parsed into correct HH:MM format
 * @return Layout with data pulled from a database in the form of a textview, a single picture, opening hours in a textview,
 * 		   and a button for retrieving weather information through a Http url connection to an openweathermap API
 * @see         Donadea Forest
 */

package com.example.fourthyearproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DonadeaForest extends Activity {

	SQLiteDatabase db;
	TextView tvlocation, tvdescription;
	String location = "Donadea Forest";
	String description = "Managed by Coillte, the Irish Forestry Service, the park was the home of the Anglo-Norman Aylmer family who occupied the castle (now in ruins) from 1550 to 1935." +
			" The castle, church, walled garden, ice-house and lake are set in over 250 hectares of parkland.";
	Button weatherbtndd;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donadealocation);

		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");
		tvlocation=(TextView)findViewById(R.id.donadealocation);
		tvdescription =(TextView)findViewById(R.id.donadeadescription);
		tvlocation.setTypeface(tf1);
		tvdescription.setTypeface(tf1);
		
		weatherbtndd = (Button) findViewById(R.id.donadeabutton);

		createtable();
		insertintotable();
		selectfromtable();
	}

	public void createtable(){
		try{
			db = openOrCreateDatabase("Mydb", Context.MODE_PRIVATE, null);
			db.execSQL("create table if not exists mytable (location varchar, description varchar);");
		}catch(Exception e){
		}
	}
	public void insertintotable(){
		try{	
			db = openOrCreateDatabase("Mydb", Context.MODE_PRIVATE, null);
			db.execSQL("insert into mytable values('"+location+"','"+description+"')");}
		catch(Exception e){
		}
	}	
	public void selectfromtable(){
		Cursor c = db.rawQuery("select * from mytable", null);

		tvlocation.setText("");
		tvdescription.setText("");
		c.moveToFirst();
		do
		{
			location = c.getString(c.getColumnIndex("location"));
			description = c.getString(1);
			tvlocation.setText(location);
			tvdescription.setText(description);
		}while(c.moveToNext());
		
		weatherbtndd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("clicks","you clicked weather button");
				Intent weatherIntent = new Intent(DonadeaForest.this, WeatherScreen.class);
				startActivity(weatherIntent);
			}
		});
	}
}