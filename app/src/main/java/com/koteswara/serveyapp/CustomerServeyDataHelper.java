package com.koteswara.serveyapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CustomerServeyDataHelper {

	static final String DATABASE_NAME = "customerserveyfeedback.db";
	static final int DATABASE_VERSION = 1;

	static final String TABLENAME_1 = "customerserveyfeedback";
	
	

	// feedback details coloumn
	public static final String KEY_FeedbackSerialNumber = "feedbackserialnumber";
	public static final String KEY_Date = "date";
	public static final String KEY_Location = "location";
	public static final String KEY_Nationality = "nationality";
	public static final String KEY_Profession = "prefession";
	public static final String KEY_Airline = "airline";
	public static final String KEY_Arrivingfrom = "arrivingfrom";
	public static final String KEY_Gender = "gender";
	public static final String KEY_AgeGroup = "agegroup";
	public static final String KEY_PurpousOfTravel = "purpousoftravel";
	public static final String KEY_FrequencyOfTravel = "frequencyoftravel";
	public static final String KEY_AwareOfDutyFreeShip = "awareofdutyfreeship";
	public static final String KEY_WhatProductYouBuy = "whatproductyoubuy";
	public static final String KEY_ConsiderPurchasing = "considerpurchasing";
	public static final String KEY_PromoteToPurchase = "promotetopurchase";
	public static final String KEY_RateExpOnDutyFreeship = "rateexpondutyfreeship";
	public static final String KEY_RateExpOnThisAirport = "rateexponthisairport";
	
	//table query
	public static final String CUSTOMER_FEEDBACK = "CREATE TABLE IF NOT EXISTS "
			+ TABLENAME_1 + "("
			+ "feedbackserialnumber INTEGER PRIMARY KEY autoincrement, "
			+ "date VARCHAR, "
			+ "location VARCHAR, " 
			+ "nationality VARCHAR, "
			+ "prefession VARCHAR, " 
			+ "airline VARCHAR, " 
			+ "arrivingfrom VARCHAR, "
			+ "gender VARCHAR, " 
			+ "agegroup VARCHAR, "
			+ "purpousoftravel VARCHAR, " 
			+ "frequencyoftravel VARCHAR, " 
			+ "awareofdutyfreeship VARCHAR, "
			+ "whatproductyoubuy VARCHAR, " 
			+ "considerpurchasing VARCHAR, "
			+ "promotetopurchase VARCHAR, " 
			+ "rateexpondutyfreeship VARCHAR, " 
			+ "rateexponthisairport VARCHAR);";
	
	public static Context serveycontext;
	private static SQLiteDatabase serveydatabase;
	private static CustomerServeyFeedBackDataBase customerfeedbackdatabase;
	
	public CustomerServeyDataHelper(Context context)
	{
		serveycontext=context;
		customerfeedbackdatabase=new CustomerServeyFeedBackDataBase(context);
	}
	
	public CustomerServeyDataHelper open() throws SQLException{
		// TODO Auto-generated method stub
		
		serveydatabase=customerfeedbackdatabase.getWritableDatabase();	
		return this;
		
	}
	
	public void close() {
		// TODO Auto-generated method stub
		customerfeedbackdatabase.close();		
	}
	
	
	private static class CustomerServeyFeedBackDataBase extends SQLiteOpenHelper{

		public CustomerServeyFeedBackDataBase(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(CUSTOMER_FEEDBACK);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLENAME_1);

			onCreate(serveydatabase);
		}
		
		
		
	}
	public long addFeedBack(String date, String location, String nationality,String prefession,
			String airline,String arrivingfrom, String gender, String agegroup,String purpousoftravel,
			String frequencyoftravel,String awareofdutyfreeship, String whatproductyoubuy, String considerpurchasing,String promotetopurchase,
			String rateexpondutyfreeship,String rateexponthisairport)
			throws SQLiteConstraintException {

		ContentValues cv = new ContentValues();
		try {
			cv.put(KEY_Date, date);
			cv.put(KEY_Location, location);
			cv.put(KEY_Nationality, nationality);
			cv.put(KEY_Profession, prefession);
			cv.put(KEY_Airline, airline);
			cv.put(KEY_Arrivingfrom, arrivingfrom);
			cv.put(KEY_Gender, gender);
			cv.put(KEY_AgeGroup, agegroup);
			cv.put(KEY_PurpousOfTravel, purpousoftravel);
			cv.put(KEY_FrequencyOfTravel, frequencyoftravel);
			cv.put(KEY_AwareOfDutyFreeShip, awareofdutyfreeship);
			cv.put(KEY_WhatProductYouBuy, whatproductyoubuy);
			cv.put(KEY_ConsiderPurchasing, considerpurchasing);
			cv.put(KEY_PromoteToPurchase, promotetopurchase);
			cv.put(KEY_RateExpOnDutyFreeship, rateexpondutyfreeship);
			cv.put(KEY_RateExpOnThisAirport, rateexponthisairport);
			

		} catch (SQLiteConstraintException e) {
			// TODO: handle exception

		}
		return serveydatabase.insert(TABLENAME_1, null, cv);
	}
	
public  Cursor getCustomerFeedback(){
				
	return	serveydatabase.query(TABLENAME_1,new String[] {KEY_FeedbackSerialNumber,KEY_Date,KEY_Location,KEY_Nationality,KEY_Profession,KEY_Airline,KEY_Arrivingfrom,KEY_Gender,
			KEY_AgeGroup,KEY_PurpousOfTravel,KEY_FrequencyOfTravel,KEY_AwareOfDutyFreeShip,KEY_WhatProductYouBuy,KEY_ConsiderPurchasing,KEY_PromoteToPurchase,
			KEY_RateExpOnDutyFreeship,KEY_RateExpOnThisAirport}, null, null, null, null, null);
		
		
		 
		
	 	
	}
	

}
