/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Returns a layout file detailing information for the Riverbank Arts Centre. 
 * It creates an SQLiteDatabase table, inserts information into it, and selects the info to be displayed using
 * SQL queries. This produces the name of the location and a blurb on the type of place it is.
 * Opening Hours are displayed to the user, and live time is taken from the user's device to tell them if the place is currently open
 * or not. A webview displays information from the official Mondello Racing Park website on the motor racing scheduling, retrieved
 * using the JSoup library and an Asynchronous task method.
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String object to declare a date to be parsed into correct HH:MM format
 * @param  String url to connect to a website and retrieve some of its Html content
 * @return Layout with data pulled from a database in the form of a textview, a single picture, opening hours in a textview,
 * 		   and a button for retrieving Html information from the official website.
 * @see    Mondello
 */

package com.example.fourthyearproject;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Mondello extends Activity {

	private WebView webView;
	SQLiteDatabase db;
	TextView tvlocation, tvdescription;

	String location = "Mondello Park Racing Track";
	String description = "An exciting programme of car and motorbike racing is held at Mondello every year. " +
			"In addition, there is a Racing Driving School, where people can get instruction and tuition.";

	// URL Address
	String url = "http://www.mondellopark.ie/upcoming-events/"; //to be updated before demonstration
	ProgressDialog mProgressDialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mondello);
		
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");
		tvlocation = (TextView)findViewById(R.id.mondellolocation);
		tvdescription =(TextView)findViewById(R.id.mondellodescription);
		tvlocation.setTypeface(tf1);
		tvdescription.setTypeface(tf1);
		
		createtable();
		insertintotable();
		selectfromtable();

		// Locate the Buttons in riverbanklocation.xml
		Button mondellobutton = (Button) findViewById(R.id.mondellobutton);
		// Capture button click
		mondellobutton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// Execute Description AsyncTask
				new Description().execute();
			}
		});

	}

	// Description AsyncTask
	private class Description extends AsyncTask<Void, Void, Void> {
		String webContent;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(Mondello.this);
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
				webContent = document.getElementsByClass("mondelloLineTop").outerHtml();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// Set description into TextView
			webView = (WebView) findViewById(R.id.mondelloweb);
			webView.loadData(webContent, "text/html", "UTF-8");
			mProgressDialog.dismiss();
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

		tvlocation.setText("");
		tvdescription.setText("");

		c.moveToFirst();
		do
		{
			location = c.getString(c.getColumnIndex("location"));
			description = c.getString(1);

			tvlocation.setText(location);
			tvdescription.setText(description);
		}while(c.moveToNext());}
}