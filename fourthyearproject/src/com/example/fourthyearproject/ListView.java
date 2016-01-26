/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Produces a layout file with 25 checkboxes and names of tourist locations in kildare in a list format.
 * User's can check the checkbox to mark an area as visited, where checkbox states are remembered by the system
 * through the use of SharedPreferences
 * 
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @param  String key to set checkbox to the same state it was in the last time the user used them
 * @param  String 'key' and Boolean 'Value' allow for checkbox state to be saved in SP as name/value pairs
 * @param  Boolean isChecked, saves the checked state of the checkbox into sharedpreferences
 * @return Layout with 25 checkboxes including titles, with a 'Visited' label informing users of the purpose of the checboxes
 * @see    ListView
 */

package com.example.fourthyearproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class ListView extends Activity implements OnCheckedChangeListener{

	public static final String STRING_PAYLOAD = null; //testing stuff
	TextView tvlist;
	
	protected void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		setContentView(R.layout.list2);

//		//Set font of this textView and underline it
//		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/FiraSansBold.otf");
//		tvlist = (TextView)findViewById(R.id.tvlist);
//		tvlist.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG); //Underline 'Visited'
//		tvlist.setTypeface(tf1);
		
		//Declare 25 checkboxes
		final CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,
		cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25;

		// Set up each checboxes SharedPreferences and onLongClick listener taking them to the corresponding location screen
		cb1 = (CheckBox)findViewById(R.id.checkBox1);
		cb1.setChecked(getFromSP("cb1"));
		cb1.setOnCheckedChangeListener(ListView.this); 
		cb1.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb1.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		
		cb2 = (CheckBox)findViewById(R.id.checkBox2);
		cb2.setChecked(getFromSP("cb2"));
		cb2.setOnCheckedChangeListener(ListView.this);
		cb2.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb2.isLongClickable()) {
					Intent i2 = new Intent(ListView.this, CurraghRaceCourse.class);
					startActivity(i2);
				}
				return false;
			}
		});
		
		cb3 = (CheckBox)findViewById(R.id.checkBox3);
		cb3.setChecked(getFromSP("cb3"));
		cb3.setOnCheckedChangeListener(ListView.this);
		cb3.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb3.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Mondello.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb4 = (CheckBox)findViewById(R.id.checkBox4);
		cb4.setChecked(getFromSP("cb4"));
		cb4.setOnCheckedChangeListener(ListView.this);
		cb4.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb4.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, KildareVillage.class);
					startActivity(i1);
				}
				return false;
			}
		});

		cb5 = (CheckBox)findViewById(R.id.checkBox5);
		cb5.setChecked(getFromSP("cb5"));
		cb5.setOnCheckedChangeListener(ListView.this);
		cb5.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb5.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, DonadeaForest.class);
					startActivity(i1);
				}
				return false;
			}
		});
		
		cb6 = (CheckBox)findViewById(R.id.checkBox6);
		cb6.setChecked(getFromSP("cb6"));
		cb6.setOnCheckedChangeListener(ListView.this);
		cb6.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb6.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		
		cb7 = (CheckBox)findViewById(R.id.checkBox7);
		cb7.setChecked(getFromSP("cb7"));
		cb7.setOnCheckedChangeListener(ListView.this);
		cb7.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb7.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		
		cb8 = (CheckBox)findViewById(R.id.checkBox8);
		cb8.setChecked(getFromSP("cb8"));
		cb8.setOnCheckedChangeListener(ListView.this);
		cb8.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb8.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb9 = (CheckBox)findViewById(R.id.checkBox9);
		cb9.setChecked(getFromSP("cb9"));
		cb9.setOnCheckedChangeListener(ListView.this);
		cb9.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb9.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb10 = (CheckBox)findViewById(R.id.checkBox10);
		cb10.setChecked(getFromSP("cb10"));
		cb10.setOnCheckedChangeListener(ListView.this);
		cb10.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb10.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb11 = (CheckBox)findViewById(R.id.checkBox11);
		cb11.setChecked(getFromSP("cb11"));
		cb11.setOnCheckedChangeListener(ListView.this);
		cb11.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb11.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, KildareVillage.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb12 = (CheckBox)findViewById(R.id.checkBox12);
		cb12.setChecked(getFromSP("cb12"));
		cb12.setOnCheckedChangeListener(ListView.this);
		cb12.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb12.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb13 = (CheckBox)findViewById(R.id.checkBox13);
		cb13.setChecked(getFromSP("cb13"));
		cb13.setOnCheckedChangeListener(ListView.this);
		cb13.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb13.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb14 = (CheckBox)findViewById(R.id.checkBox14);
		cb14.setChecked(getFromSP("cb14"));
		cb14.setOnCheckedChangeListener(ListView.this);
		cb14.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb14.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb15 = (CheckBox)findViewById(R.id.checkBox15);
		cb15.setChecked(getFromSP("cb15"));
		cb15.setOnCheckedChangeListener(ListView.this);
		cb15.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb15.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb16 = (CheckBox)findViewById(R.id.checkBox16);
		cb16.setChecked(getFromSP("cb16"));
		cb16.setOnCheckedChangeListener(ListView.this);
		cb16.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb16.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb17 = (CheckBox)findViewById(R.id.checkBox17);
		cb17.setChecked(getFromSP("cb17"));
		cb17.setOnCheckedChangeListener(ListView.this);
		cb17.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb17.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
		cb18 = (CheckBox)findViewById(R.id.checkBox18);
		cb18.setChecked(getFromSP("cb18"));
		cb18.setOnCheckedChangeListener(ListView.this);
		cb18.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (cb18.isLongClickable()) {
					Intent i1 = new Intent(ListView.this, Riverbank.class);
					startActivity(i1);
				}
				return false;
			}
		});
//		cb19 = (CheckBox)findViewById(R.id.checkBox19);
//		cb19.setChecked(getFromSP("cb19"));
//		cb19.setOnCheckedChangeListener(ListView.this);
//		cb19.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb19.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
//		cb20 = (CheckBox)findViewById(R.id.checkBox20);
//		cb20.setChecked(getFromSP("cb20"));
//		cb20.setOnCheckedChangeListener(ListView.this);
//		cb20.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb20.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
//		cb21 = (CheckBox)findViewById(R.id.checkBox21);
//		cb21.setChecked(getFromSP("cb21"));
//		cb21.setOnCheckedChangeListener(ListView.this);
//		cb21.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb21.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
//		cb22 = (CheckBox)findViewById(R.id.checkBox22);
//		cb22.setChecked(getFromSP("cb22"));
//		cb22.setOnCheckedChangeListener(ListView.this);
//		cb22.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb22.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
//		cb23 = (CheckBox)findViewById(R.id.checkBox23);
//		cb23.setChecked(getFromSP("cb23"));
//		cb23.setOnCheckedChangeListener(ListView.this);
//		cb23.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb23.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
//		cb24 = (CheckBox)findViewById(R.id.checkBox24);
//		cb24.setChecked(getFromSP("cb24"));
//		cb24.setOnCheckedChangeListener(ListView.this);
//		cb24.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb24.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
//		cb25 = (CheckBox)findViewById(R.id.checkBox25);
//		cb25.setChecked(getFromSP("cb25"));
//		cb25.setOnCheckedChangeListener(ListView.this);
//		cb25.setOnLongClickListener(new View.OnLongClickListener() {
//
//			@Override
//			public boolean onLongClick(View v) {
//				if (cb24.isLongClickable()) {
//					Intent i1 = new Intent(ListView.this, Riverbank.class);
//					startActivity(i1);
//				}
//				return false;
//			}
//		});
	}

	//Shared Preferences Functionality
	private boolean getFromSP(String key){ 
		SharedPreferences preferences = getApplicationContext().getSharedPreferences("FOURTHYEARPROJECT", android.content.Context.MODE_PRIVATE);
		return preferences.getBoolean(key, false);
	}
	private void saveInSp(String key,boolean value){
		SharedPreferences preferences = getApplicationContext().getSharedPreferences("FOURTHYEARPROJECT", android.content.Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch(buttonView.getId()){
		case R.id.checkBox1:
			saveInSp("cb1",isChecked);
			break;
			
		case R.id.checkBox2:
			saveInSp("cb2",isChecked);
			break;

		case R.id.checkBox3:
			saveInSp("cb3",isChecked);
			break;

		case R.id.checkBox4:
			saveInSp("cb4",isChecked);
			break;

		case R.id.checkBox5:
			saveInSp("cb5",isChecked);
			break;

		case R.id.checkBox6:
			saveInSp("cb6",isChecked);
			break;

		case R.id.checkBox7:
			saveInSp("cb7",isChecked);
			break;

		case R.id.checkBox8:
			saveInSp("cb8",isChecked);
			break;

		case R.id.checkBox9:
			saveInSp("cb9",isChecked);
			break;

		case R.id.checkBox10:
			saveInSp("cb10",isChecked);
			break;

		case R.id.checkBox11:
			saveInSp("cb11",isChecked);
			break;

		case R.id.checkBox12:
			saveInSp("cb12",isChecked);
			break;

		case R.id.checkBox13:
			saveInSp("cb13",isChecked);
			break; 

		case R.id.checkBox14:
			saveInSp("cb14",isChecked);
			break;

		case R.id.checkBox15:
			saveInSp("cb15",isChecked);
			break;

		case R.id.checkBox16:
			saveInSp("cb16",isChecked);
			break;

		case R.id.checkBox17:
			saveInSp("cb17",isChecked);
			break;

		case R.id.checkBox18:
			saveInSp("cb18",isChecked);
			break;

		case R.id.checkBox19:
			saveInSp("cb19",isChecked);
			break;

		case R.id.checkBox20:
			saveInSp("cb20",isChecked);
			break;

		case R.id.checkBox21:
			saveInSp("cb21",isChecked);
			break;

		case R.id.checkBox22:
			saveInSp("cb22",isChecked);
			break;

		case R.id.checkBox23:
			saveInSp("cb23",isChecked);
			break;

		case R.id.checkBox24:
			saveInSp("cb24",isChecked);
			break;

		case R.id.checkBox25:
			saveInSp("cb25",isChecked);
			break;
		}
	}
}