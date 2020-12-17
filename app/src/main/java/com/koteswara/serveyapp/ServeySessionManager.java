package com.koteswara.serveyapp;


import java.util.HashMap;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class ServeySessionManager {
	// Shared Preferences

		SharedPreferences pref;

		// Editor for Shared preferences
		Editor editor;

		// Context
		Context _context;

		// Shared pref mode
		int PRIVATE_MODE = 0;
		private static final String PREF_NAME = "feddback";

		// All Shared Preferences Keys
		private static final String IS_FEEDBACK= "isfeedback";
		// All Shared Preferences Keys
		public static final String KEY_Location = "location";
		public static final String KEY_Nationality = "nationality";
		
		public static final String KEY_Profession = "profession";
		public static final String KEY_Airline = "airline";
		public static final String KEY_Gender = "gender";
		 
		public static final String KEY_ArrivingFrom = "arrivingfrom";
		public static final String KEY_Agegroup = "agegroup";
		public static final String KEY_Q1 = "q1";
		public static final String KEY_Q2 = "q2";
		
		public static final String KEY_Q3 = "q3";
		public static final String KEY_Q4 = "q4";
		public static final String KEY_Q5 = "q5";
		 
		public static final String KEY_Q6 = "q6";
		public static final String KEY_Q7 = "q7";
		public static final String KEY_Q8 = "q8";
		
		
		public static final String KEY_TEXT = "text";
		public static final String KEY_STAR = "star";
		
		public ServeySessionManager(Context context){
			this._context = context;
			pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
			editor = pref.edit();
		}
		public void createServeySessionlocation( String location){
			// Storing login value as TRUE
		

			// Storing name in pref
			editor.putString(KEY_Location, location);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionNationality(String nationality){
			// Storing login value as TRUE
			
			// Storing email in pref
			editor.putString(KEY_Nationality, nationality);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionProfession( String profession){
			// Storing login value as TRUE
		

			editor.putString(KEY_Profession, profession);
			
			// commit changes
			editor.commit();
		} 
		public void createServeySessionAirline( String airline){
			// Storing login value as TRUE
		

			editor.putString(KEY_Airline, airline);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionGender( String gender){
			// Storing login value as TRUE
		

			editor.putString(KEY_Gender, gender);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionArrivingfrom( String arrivingfrom){
			// Storing login value as TRUE
		

			editor.putString(KEY_ArrivingFrom, arrivingfrom);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionAgegroup( String agegroup){
			// Storing login value as TRUE
		

			editor.putString(KEY_Agegroup, agegroup);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ1( String q1){
			// Storing login value as TRUE
		

			// Storing name in pref
			editor.putString(KEY_Q1, q1);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ2(String q2){
			// Storing login value as TRUE
			
			// Storing email in pref
			editor.putString(KEY_Q2, q2);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ3( String q3){
			// Storing login value as TRUE
		

			editor.putString(KEY_Q3, q3);
			
			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ4( String q4){
			// Storing login value as TRUE
		

			editor.putString(KEY_Q4, q4);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ5( String q5){
			// Storing login value as TRUE
		

			editor.putString(KEY_Q5, q5);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ6( String q6){
			// Storing login value as TRUE
		

			editor.putString(KEY_Q6, q6);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ7( String q7){
			// Storing login value as TRUE
		

			editor.putString(KEY_Q7, q7);

			// commit changes
			editor.commit();
		} 
		public void createServeySessionQ8( String q8){
			// Storing login value as TRUE
		

			editor.putString(KEY_Q8, q8);

			// commit changes
			editor.commit();
		} 
		public void createRouteSessionText(String text){
			// Storing login value as TRUE
		

			editor.putString(KEY_TEXT, text);
	
			// commit changes
			editor.commit();
		} 
		public void createRouteSessionStar( String star){
			// Storing login value as TRUE
			
			editor.putString(KEY_STAR, star);
			
			// commit changes
			editor.commit();
		} 
		
		public void logoutUser(){
			// Clearing all data from Shared Preferences
			editor.clear();
			editor.commit();

			
		}
		
		public HashMap<String, String> getServeySessionDetails(){
			HashMap<String, String> user = new HashMap<String, String>();
			// user name
			
			user.put(KEY_Location, pref.getString(KEY_Location, null));
			user.put(KEY_Nationality, pref.getString(KEY_Nationality, null));
			user.put(KEY_Profession, pref.getString(KEY_Profession, null));
			user.put(KEY_Airline, pref.getString(KEY_Airline, null));
			user.put(KEY_Gender, pref.getString(KEY_Gender, null));
			user.put(KEY_ArrivingFrom, pref.getString(KEY_ArrivingFrom, null));
			user.put(KEY_Agegroup, pref.getString(KEY_Agegroup, null));
			
			user.put(KEY_Q1, pref.getString(KEY_Q1, null));
			user.put(KEY_Q2, pref.getString(KEY_Q2, null));
			user.put(KEY_Q3, pref.getString(KEY_Q3, null));
			user.put(KEY_Q4, pref.getString(KEY_Q4, null));
			user.put(KEY_Q5, pref.getString(KEY_Q5, null));
			user.put(KEY_Q6, pref.getString(KEY_Q6, null));
			user.put(KEY_Q7, pref.getString(KEY_Q7, null));
			user.put(KEY_Q8, pref.getString(KEY_Q8, null));
			
			user.put(KEY_TEXT, pref.getString(KEY_TEXT, null));		
			user.put(KEY_STAR, pref.getString(KEY_STAR, null));


			// return user
			return user;
		}
		
		
}
