/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Returns a layout file with the title of the application,
 * and 3 buttons that give users the options to view the next screens
 *
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @return      Layout with 3 textViews and 3 buttons for navigating the app
 * @see         OpeningMenu
 */

package com.example.fourthyearproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OpeningMenu extends Activity {

	/*public static String EXTRAS_PAYLOAD_KEY;
	String value; */ //for testing
	Button wheretogobtn, whattodobtn, aboutbtn;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opening);
		
		getActionBar().hide();

		//Set the font of the title's textview
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");
		TextView tv1 = (TextView) findViewById(R.id.openingtext1);
		tv1.setTypeface(tf1);

//		TextView tv2 = (TextView) findViewById(R.id.openingtext2);
//		tv2.setTypeface(tf1);
//
//		TextView tv3 = (TextView) findViewById(R.id.openingtext3);
//		tv3.setTypeface(tf1);

		//Declare id's for buttons and implement there click listeners. Each has an intent that takes the user to the next class
		whattodobtn = (Button) findViewById(R.id.whattodobtn);
		wheretogobtn = (Button) findViewById(R.id.wheretogobtn);
		aboutbtn = (Button) findViewById(R.id.aboutbtn);

		whattodobtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("clicks","you clicked what to do button");
				Intent whattodointent = new Intent(OpeningMenu.this, ListView.class);//.putExtra(EXTRAS_PAYLOAD_KEY, value);
				startActivity(whattodointent);
			}
		});

		wheretogobtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("clicks","you clicked Where To Go button");
				Intent wheretogointent = new Intent(OpeningMenu.this, MapView.class);
				startActivity(wheretogointent);
			}
		});

		aboutbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("clicks","you clicked about button");
				Intent aboutintent = new Intent(OpeningMenu.this, AboutScreen.class);
				startActivity(aboutintent);
			}
		}); 
	}
}