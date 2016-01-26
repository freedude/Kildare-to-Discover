/**
 * @author Seán Freeman <seanfreemantya@gmail.com>
 * @version 1.0
 * 
 * Returns a map fragment showing markers for the 25 different tourist spots in Kildare.
 * 5 of these locations info windows are clickable, taking you to the corresponding location
 * these are: Riverbank Arts Centre, Mondello Park, Kildare Village, Donadea Forest, and the Curragh Racecourse
 *
 * @param  savedInstanceState Saved data that the system uses to restore the previous state
 * @return      Layout with GoogleMap fragment displaying 25 markers for tourist locations, 5 of which are clickable
 * @see         MapView
 */

package com.example.fourthyearproject;

import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends FragmentActivity {

	// Map and marker declarations
	private GoogleMap map;
	private Marker riverbankmarker, curraghmarker, mondellomarker, villagemarker, donadeamarker;
	
	//Lattitude + Longitude values for each tourist location
	private final LatLng LOCATION_CURRAGHRACE = new LatLng(53.164163, -6.843023), LOCATION_ATHY = new LatLng(52.990090, -6.967993),
			LOCATION_BALLITORE = new LatLng(52.9945968,-6.9861524), LOCATION_CARBURY = new LatLng(53.381685, -7.026957),LOCATION_CASTLEDERMOT = new LatLng(52.943772, -6.886968),
			LOCATION_CELBRIDGE = new LatLng(53.348882, -6.529870),LOCATION_CLANE = new LatLng(53.306667, -6.666468), LOCATION_DONADEAFOREST = new LatLng(53.341094, -6.744790),
			LOCATION_WALLABY = new LatLng(53.353391, -6.792855),LOCATION_KILCOCK = new LatLng(53.399120, -6.667266),LOCATION_KILDARESTUD = new LatLng(53.142957, -6.901045),
			LOCATION_KILDAREVILLAGE = new LatLng(53.153664, -6.916151), LOCATION_LEIXLIP = new LatLng(53.364473, -6.487601),LOCATION_MAYNOOTHCASTLE = new LatLng(53.380386, -6.593624),
			LOCATION_MAYNOOTHGARDENS = new LatLng(53.378031, -6.601005), LOCATION_NAASMOAT = new LatLng(53.218031, -6.663594), LOCATION_NAASMONDELLO = new LatLng(53.257893, -6.745992),
			LOCATION_NAASPUNCHESTOWN = new LatLng(53.185538, -6.628575), LOCATION_NEWBSILVERWARE = new LatLng(53.175996, -6.796503),LOCATION_RIVERBANK = new LatLng(53.181952, -6.794522),
			LOCATION_WHITEWATER = new LatLng(53.177977, -6.798177), LOCATION_CURRAGHGOLFCLUB = new LatLng(52.9945968,-6.9861524), LOCATION_PROSPEROUS = new LatLng(53.306335, -6.763158),
			LOCATION_RATHANGAN = new LatLng(53.270214, -6.949239), LOCATION_STRAFFANBUTTERFLY = new LatLng(53.314130, -6.635442), LOCATION_STRAFFANSTEAM = new LatLng(53.311669, -6.598363),
			LOCATION_KCLUB = new LatLng(53.308797, -6.618275);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		//Set our map to the map fragment contained in map.xml file
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		// Set up Markers for each tourist hot spot, color co-ordinated based on the type of location
		map.addMarker(new MarkerOptions().position(LOCATION_ATHY).title("Athy Heritage Centre Museum").snippet("Museum")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
		map.addMarker(new MarkerOptions().position(LOCATION_BALLITORE).title("Ballitore Quaker Museum").snippet("Museum")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
		map.addMarker(new MarkerOptions().position(LOCATION_CARBURY).title("Balindoolin House & Gardens").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_CASTLEDERMOT).title("Kilkea Castle Golf Club").snippet("Golf Club")
		.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
		map.addMarker(new MarkerOptions().position(LOCATION_CELBRIDGE).title("Castletown House").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_CLANE).title("Abbeyfield Farm Country Pursuits").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		donadeamarker = map.addMarker(new MarkerOptions().position(LOCATION_DONADEAFOREST).title("Donadea Forest Park").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_WALLABY).title("Wallaby Woods").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_KILCOCK).title("Kilcock Art Gallery").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_KILDARESTUD).title("Irish National Stud & Japanese Gardens").snippet("Equestrian")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
		villagemarker = map.addMarker(new MarkerOptions().position(LOCATION_KILDAREVILLAGE).title("Kildare Village Outlet Shopping").snippet("Equestrian")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));;
		map.addMarker(new MarkerOptions().position(LOCATION_LEIXLIP).title("Leixlip Castle").snippet("Castle")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
		map.addMarker(new MarkerOptions().position(LOCATION_MAYNOOTHCASTLE).title("Maynooth Castle").snippet("Castle")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
		map.addMarker(new MarkerOptions().position(LOCATION_MAYNOOTHGARDENS).title("Maynooth Bi-Centenary Gardens").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_NAASMOAT).title("Moat Theatre Naas").snippet("Theatre")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
		mondellomarker = map.addMarker(new MarkerOptions().position(LOCATION_NAASMONDELLO).title("Mondello Park Naas").snippet("Car Racing")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
		map.addMarker(new MarkerOptions().position(LOCATION_NAASPUNCHESTOWN).title("Punchestown Racecourse").snippet("Equestrian")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
		map.addMarker(new MarkerOptions().position(LOCATION_NEWBSILVERWARE).title("Newbridge Silverware").snippet("Shopping")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
		riverbankmarker = map.addMarker(new MarkerOptions().position(LOCATION_RIVERBANK).title("Riverbank Arts Centre").snippet("Theatre")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));;
		map.addMarker(new MarkerOptions().position(LOCATION_WHITEWATER).title("Whitewater Shopping Centre").snippet("Shopping")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
		map.addMarker(new MarkerOptions().position(LOCATION_CURRAGHGOLFCLUB).title("Curragh Golf Club").snippet("Golf Club")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));;
		curraghmarker = map.addMarker(new MarkerOptions().position(LOCATION_CURRAGHRACE).title("Curragh Race Course").snippet("Equestrian")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
		map.addMarker(new MarkerOptions().position(LOCATION_PROSPEROUS).title("The Kildare Maze").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_RATHANGAN).title("Lullymore Heritage Park").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		map.addMarker(new MarkerOptions().position(LOCATION_STRAFFANBUTTERFLY).title("Straffan Butterfly Farm").snippet("Attractions")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));;
		map.addMarker(new MarkerOptions().position(LOCATION_STRAFFANSTEAM).title("Straffan Steam Museum").snippet("Museum")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		map.addMarker(new MarkerOptions().position(LOCATION_KCLUB).title("The K Club").snippet("Golf Club")
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
		
		

		// Set up infoWindow click listeners with intents
		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

			@Override
			public void onInfoWindowClick(Marker marker) {
				if(marker.equals(riverbankmarker)){
					Intent i = new Intent(MapView.this,Riverbank.class);
					startActivity(i);
				}
				if (marker.equals(curraghmarker)){
					Intent i = new Intent(MapView.this,CurraghRaceCourse.class);
					startActivity(i);
				}
				if (marker.equals(mondellomarker)){
					Intent i = new Intent(MapView.this,Mondello.class);
					startActivity(i);
				}
				if (marker.equals(villagemarker)){
					Intent i = new Intent(MapView.this,KildareVillage.class);
					startActivity(i);
				}
				if (marker.equals(donadeamarker)){
					Intent i = new Intent(MapView.this,DonadeaForest.class);
					startActivity(i);
				}
			}
		}); 
		
		map.setMyLocationEnabled(true);
		
		
	}
}