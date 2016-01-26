/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Returns a layout file that can be used to find out what this application does 
 *
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @return      Layout with 3 textViews on what the application does
 * @see         AboutScreen
 */

package com.example.fourthyearproject;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class AboutScreen extends Activity {

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		//Changes font of textViews to FiraSansSemiBold.otf in the assets/font folder
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansSemiBold.otf");
		TextView tv1 = (TextView) findViewById(R.id.abouttxt1);
		tv1.setTypeface(tf1);
		
		TextView tv2 = (TextView) findViewById(R.id.abouttxt2);
		tv2.setTypeface(tf1);
		
		TextView tv3 = (TextView) findViewById(R.id.abouttxt3);
		tv3.setTypeface(tf1);
	}
}