/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Returns a layout file detailing information for the Riverbank Arts Centre. 
 * It creates an SQLiteDatabase table, inserts information into it, and selects the info to be displayed using
 * SQL queries. This produces the name of the location and a blurb on the type of place it is.
 * Opening Hours are displayed to the user, and live time is taken from the user's device to tell them 
 * if the place is currently open or not. 
 * A webview displays information from the official Riverbank website on the theatre's scheduling, retrieved
 * using the JSoup library and an Asynchronous task method.
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String object to declare a date to be parsed into correct HH:MM format
 * @param  String url to connect to a website and retrieve some of its Html content
 * @return Layout with data pulled from a database in the form of a textview, a single picture, opening hours in a
 * 		   textview, and a button for retrieving Html information from the official website.
 * @see    Riverbank
 */

package com.example.fourthyearproject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Riverbank extends Activity {

	private WebView webView; //Create web view

	SQLiteDatabase db; //Create instance of SQLiteDatabase

	TextView tvlocation, tvdescription; //Set up text views for location name and blurb description

	//Set up variable's for displaying opening times, and whether a place is currently open or not
	TextView time;
	String inputFormat = "HH:mm";
	Date date, openingtime, closingtime;
	String compareOpeningTime = "09:00";
	String compareClosingTime = "17:30";
	SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.UK);

	//Data to be passed to database
	String location = "Riverbank Arts Centre";
	String description = "Enjoy Music, Theatre, Opera, Ballet, Comedy, Workshops and much more at Riverbank Arts Centre. Dont forget to visit our Visual Arts Exhibition at McKenna Gallery, and spend some time at our dedicated Childrens Gallery - A world of creative inspiration for all the family.";

	// URL Address
	String url = "http://www.riverbank.ie/events/";
	ProgressDialog pd;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.riverbanklocation);

		//Set font
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");

		tvlocation = (TextView)findViewById(R.id.riverbanklocation);
		tvdescription =(TextView)findViewById(R.id.riverbankdescription);
		tvlocation.setTypeface(tf1);
		tvdescription.setTypeface(tf1);

		OpeningHours();

		createtable();
		insertintotable();
		selectfromtable();

		// Button for web display
		Button descbutton = (Button) findViewById(R.id.descbutton);
		descbutton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				new webDetails().execute(); // Execute description AsyncTask
			}
		});
	}
	//Method to determine whether Riverbank is currently open or not
	public void OpeningHours(){
		Calendar now = Calendar.getInstance();

		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);

		time = (TextView) findViewById(R.id.time);

		date = parseDate(+hour + ":" +minute);
		openingtime = parseDate(compareOpeningTime);
		closingtime = parseDate(compareClosingTime);

		if (openingtime.before(date) && closingtime.after(date)){ //Display green text during opening hours
			time.setText("Currently open");
			time.setTextColor(Color.parseColor("#66FF66")); 
		}
		else {
			time.setText("Currently closed"); //Display red text during closing hours
			time.setTextColor(Color.RED);
		}
	}

	private Date parseDate(String date){
		try{
			return inputParser.parse(date);
		}catch (java.text.ParseException e){
			return new Date(0);
		}
	}

	// webDetails asynchronous task method. Displays progress dialog as Jsoup connects to url and retrieves html in the background
	private class webDetails extends AsyncTask<Void, Void, Void> {
		String webContent;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(Riverbank.this);
			pd.setTitle("Fetching Live Data");
			pd.setMessage("Loading...");
			pd.setIndeterminate(false); //constantly moving loader bar as opposed to % because we don't know how long the process will take based on users Internet connection
			pd.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Document document = Jsoup.connect(url).get(); // Connect to the web site
				webContent = document.getElementById("tribe-events").outerHtml(); // Using Elements to get the data
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override //dismiss progress dialog and display retrieved information in webview
		protected void onPostExecute(Void result) {
			// Set details into TextView
			webView = (WebView) findViewById(R.id.webtxt);
			webView.loadData(webContent, "text/html", "UTF-8");
			pd.dismiss();
		}
	}
	//Create table in SQLite Database
	public void createtable(){
		try{
			db = openOrCreateDatabase("Mydb", Context.MODE_PRIVATE, null);
			db.execSQL("create table if not exists mytable (location varchar, description varchar);");
		}catch(Exception e){
		}
	}
	//Insert values into this table
	public void insertintotable(){
		try{
			db = openOrCreateDatabase("Mydb", Context.MODE_PRIVATE, null);
			db.execSQL("insert into mytable values('"+location+"','"+description+"')");}
		catch(Exception e){
		}
	}	
	//Select all values from the table by means of SQL Query to be displayed in textviews
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
			tvdescription.setText(description+"\n");
		}while(c.moveToNext());}
}