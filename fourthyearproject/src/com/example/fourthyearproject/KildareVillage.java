/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Returns a layout file detailing information for the Riverbank Arts Centre. 
 * It creates an SQLiteDatabase table, inserts information into it, and selects the info to be displayed using
 * SQL queries. This produces the name of the location and a blurb on the type of place it is.
 * Opening Hours are displayed to the user, and live time is taken from the user's device to tell them if the place is currently open
 * or not. A webview displays information from the official Kildare Village website on offers and deals of the week, retrieved
 * using the JSoup library and an Asynchronous task method.
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String object to declare a date to be parsed into correct HH:MM format
 * @param  String url to connect to a website and retrieve some of its Html content
 * @return Layout with data pulled from a database in the form of a textview, a single picture, opening hours in a textview,
 * 		   and a button for retrieving Html information from the official website.
 * @see    Kildare Village
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

public class KildareVillage extends Activity {

	private WebView webView;
	SQLiteDatabase db;
	TextView tvlocation, tvdescription;
	
	TextView time;
	String inputFormat = "HH:mm";
	Date date, openingtime, closingtime;
	String compareOpeningTime = "10:00";
	String compareClosingTime = "18:00";
	SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.UK);
	
	String title;
	String location = "Kildare Village";
	String description = "Kildare Village, one of the Chic Outlet Shopping Villages in Europe," +
			" is located less than an hour from Dublin and offers Ireland’s leading luxury outlet shopping " +
			"experience.";

	// URL Address
	String url = "http://www.riverbank.ie/at-a-glance"; //to be updated before demonstration
	ProgressDialog mProgressDialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kildarevillage);
		
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");
		tvlocation=(TextView)findViewById(R.id.kildarevillagelocation);
		tvdescription =(TextView)findViewById(R.id.kildarevillagedescription);
		tvlocation.setTypeface(tf1);
		tvdescription.setTypeface(tf1);
		
		OpeningHours();
		
		createtable();
		insertintotable();
		selectfromtable();

		// Locate the Buttons in riverbanklocation.xml
		Button kildarebutton = (Button) findViewById(R.id.kildarevillagebutton);
		// Capture button click
		kildarebutton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// Execute Description AsyncTask
				new Description().execute();
			}
		});
	}

	// Description AsyncTask
	private class Description extends AsyncTask<Void, Void, Void> {
		String content1;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(KildareVillage.this);
			mProgressDialog.setTitle("Fetching Live Data");
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				// Connect to the web site
				Document document = Jsoup.connect(url).get();
				// Using Elements to get the Meta data
				content1 = document.getElementById("content").outerHtml();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// Set description into TextView
			webView = (WebView) findViewById(R.id.kildarevillageweb);
			webView.loadData(content1, "text/html", "UTF-8");
			mProgressDialog.dismiss();
		}
	}
	
	public void OpeningHours(){
		Calendar now = Calendar.getInstance();

		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);

		time = (TextView) findViewById(R.id.villagetime);

		date = parseDate(+hour + ":" +minute);
		openingtime = parseDate(compareOpeningTime);
		closingtime = parseDate(compareClosingTime);

		if (openingtime.before(date) && closingtime.after(date)){
			time.setText("Currently open");
			time.setTextColor(Color.parseColor("#66FF66"));
		}
		else {
			time.setText("Currently closed");
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

		tvdescription.setText("");
		tvlocation.setText("");
		c.moveToFirst();
		do
		{
			location = c.getString(c.getColumnIndex("location"));
			description = c.getString(1);

			tvdescription.setText(description);
			tvlocation.setText(location);
		}while(c.moveToNext());}
}