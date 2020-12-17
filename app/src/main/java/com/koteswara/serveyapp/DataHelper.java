package com.koteswara.serveyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataHelper {

	static final String DATABASE_NAME = "customerfeedback.db";
	static final int DATABASE_VERSION = 1;

	static final String TABLENAME_1 = "customerfeedback"; // ADD BIKE
																// PURCHASE
																// DETAILS
	/*static final String TABLENAME_2 = "territorytable"; // ADD NEW BIKE DETAILS
	static final String TABLENAME_3 = "logintable"; // ADD BIKE SALE DETAILS
	static final String TABLENAME_4 = "synchtable"; // ADD FILL UP DETAILS
	static final String TABLENAME_5 = "authenticatetable";// ADD EXPENSES
	static final String TABLENAME_6 = "sandwichordertable";// ADD DEPARTURE
*/															// DETAILS

	// territory coloumn
	public static final String KEY_TerritoryId = "territory_id";
	public static final String KEY_TerritoryName = "territory_name";

	// userdetail coloumn
	public static final String KEY_CustTerritorySerialNumber = "territoryserialnumber";
	public static final String KEY_FirstName = "firstname";
	public static final String KEY_LastName = "lastname";
	public static final String KEY_Name = "name";
	public static final String KEY_TelephoneNumber = "telephonenumber";
	public static final String KEY_CellPhoneNumber = "cellphonenumber";
	public static final String KEY_CompanyName = "companyname";
	public static final String KEY_Email_id = "emailid";
	public static final String KEY_Address = "address";
	public static final String KEY_StreetNumber = "streetnumber";
	public static final String KEY_BuildingNumber = "buildingnumber";
	public static final String KEY_DoorNumber = "doornumber";
	public static final String KEY_FloorNumber = "floornumber";
	public static final String KEY_LandMark = "landmark";
	public static final String KEY_DeliveryDescription = "delidescription";
	
	public static final String CUSTOMER_DETAILS = "CREATE TABLE IF NOT EXISTS "
			+ TABLENAME_1 + "("
			+ "territoryserialnumber VARCHAR, "
			+ "firstname VARCHAR, " + "lastname VARCHAR, "+ "name VARCHAR, "
			+ "telephonenumber INTEGER, " + "cellphonenumber INTEGER, "
			+ "companyname VARCHAR, " + "emailid VARCHAR, "
			+ "address VARCHAR, " + "streetnumber VARCHAR, "
			+ "buildingnumber VARCHAR, " + "doornumber VARCHAR, "
			+ "floornumber VARCHAR, " + "landmark VARCHAR, "
			+ "delidescription VARCHAR);";
	public static final String CUSTOMER_FEEDBACK = "CREATE TABLE IF NOT EXISTS "
			+ TABLENAME_1 + "("
			+ "territoryserialnumber INTEGER PRIMARY KEY autoincrement, "
			+ "phonenumber INTEGER, "
			+ "question1 VARCHAR, " 
			+ "question2 VARCHAR, "
			+ "qiestion3 VARCHAR, " 
			+ "rating VARCHAR, " 
			+ "feedtext VARCHAR);";
	// login column

	public static final String KEY_LoginUserName = "username";
	public static final String KEY_LoginPassword = "password";

	// authenticate column
	public static final String KEY_Authenticate_securitikey = "securitykey";

	// ordertable column
	public static final String KEY_CurrentTime = "currenttime";
	public static final String KEY_CurrentDate = "currentdate";
	public static final String KEY_CellPhoneNumber_o = "cellphonenumber";
	public static final String KEY_deliveryDate = "deliverydate";
	public static final String KEY_deliveryTime = "deliverytime";

	public static final String KEY_BreadSelection = "breadselection";
	public static final String KEY_MeatSelection = "meatselection";
	public static final String KEY_CheeseSelecton = "cheeseselection";
	public static final String KEY_SeasoningSelection = "seasoningselection";
	public static final String KEY_VegitablesExclusion = "vegitablesexcusion";

	public static Context ourcontext;
	private static SQLiteDatabase mydatabase;
	private static MySandDataBase mysanddatabase;
	
	//ustomerfeedback column
	public static final String KEY_feedbackSerialNumber = "feedbackserialnumber";
	public static final String KEY_PhoneNumber = "phonenumber";
	public static final String KEY_question1 = "question1";
	public static final String KEY_question2 = "question2";
	public static final String KEY_qiestion3 = "qiestion3";
	public static final String KEY_rating = "rating";
	public static final String KEY_feedtext = "feedtext";

	
	public DataHelper(Context context)
	{
		ourcontext=context;
		mysanddatabase=new MySandDataBase(context);
	}
	
	public DataHelper open() throws SQLException{
		// TODO Auto-generated method stub
		
		mydatabase=mysanddatabase.getWritableDatabase();	
		return this;
		
	}
	
	public void close() {
		// TODO Auto-generated method stub
		mysanddatabase.close();		
	}

	
	private static class MySandDataBase extends SQLiteOpenHelper {

		public MySandDataBase(Context context) {
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

			onCreate(mydatabase);

		}

	}


	public long addFeedBack(String q1, String q2, String q3,String rating,
			String feedbacktext)
			throws SQLiteConstraintException {

		ContentValues cv = new ContentValues();
		try {
			cv.put(KEY_question1, q1);
			cv.put(KEY_question2, q2);
			cv.put(KEY_qiestion3, q3);
			cv.put(KEY_rating, rating);
			cv.put(KEY_feedtext, feedbacktext);
			

		} catch (SQLiteConstraintException e) {
			// TODO: handle exception

		}
		return mydatabase.insert(TABLENAME_1, null, cv);
	}
	
public  Cursor getCustomerFeedback(){
		
		
	//	ArrayList<String> customerdetails= new ArrayList<String>();
		
		
		/*Cursor c= mydatabase.query(TABLENAME_1,new String[] {KEY_CustTerritorySerialNumber,KEY_FirstName,KEY_LastName,
				KEY_TelephoneNumber,KEY_CellPhoneNumber}, null, null, null, null, null);*/
	return	mydatabase.query(TABLENAME_1,new String[] {KEY_CustTerritorySerialNumber,KEY_question1,KEY_question2,
				KEY_qiestion3,KEY_feedtext,KEY_rating}, null, null, null, null, null);
		
		
		 
		
	 	
	}
	
	public  ArrayList<String> getCustomerDetailsByTelephoneNumber(String telephonenumber){
		
		
		ArrayList<String> customerdetails= new ArrayList<String>();
		
		
		Cursor c= mydatabase.query(TABLENAME_1,new String[] {KEY_CustTerritorySerialNumber,KEY_FirstName,KEY_LastName,
				KEY_TelephoneNumber,KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id,KEY_Address,KEY_StreetNumber,
				KEY_BuildingNumber,KEY_DoorNumber,KEY_FloorNumber,KEY_LandMark,KEY_DeliveryDescription}, KEY_TelephoneNumber + "= '" + telephonenumber + "'", null, null, null, null);
		
		 int territorynumber=c.getColumnIndex(KEY_CustTerritorySerialNumber);
		 int firstname=c.getColumnIndex(KEY_FirstName);
		 int lastname=c.getColumnIndex(KEY_LastName);
		 int telephonumber=c.getColumnIndex(KEY_TelephoneNumber);
		 int cellnumber=c.getColumnIndex(KEY_CellPhoneNumber);
		 int company=c.getColumnIndex(KEY_CompanyName);
		 int emailid=c.getColumnIndex(KEY_Email_id);
		 int address=c.getColumnIndex(KEY_Address);
		 int streetnumber=c.getColumnIndex(KEY_StreetNumber);
		 int buildingnymber=c.getColumnIndex(KEY_BuildingNumber);
		 int doornumber=c.getColumnIndex(KEY_DoorNumber);
		 int floornumber=c.getColumnIndex(KEY_FloorNumber);
		 int landnumber=c.getColumnIndex(KEY_LandMark);
		 int delidesription=c.getColumnIndex(KEY_DeliveryDescription);
		
		 if (c.moveToFirst())
	        {
	            do {      
	            	customerdetails.add(c.getString(territorynumber));
	    			customerdetails.add(c.getString(firstname));
	    			customerdetails.add(c.getString(lastname));
	    			customerdetails.add(c.getString(telephonumber));
	    			customerdetails.add(c.getString(cellnumber));
	    			customerdetails.add(c.getString(company));
	    			customerdetails.add(c.getString(emailid));
	    			customerdetails.add(c.getString(address));
	    			customerdetails.add(c.getString(streetnumber));
	    			customerdetails.add(c.getString(buildingnymber));
	    			customerdetails.add(c.getString(doornumber));
	    			customerdetails.add(c.getString(floornumber));
	    			customerdetails.add(c.getString(landnumber));
	    			customerdetails.add(c.getString(delidesription));
	            } while (c.moveToNext());
	           
	        }
	        c.close();
		
	 	return customerdetails;	
	}
public  ArrayList<String> getCustomerDetailsByCellNumber(String cellphonenumber){
		
		
		ArrayList<String> customerdetails= new ArrayList<String>();
		
		
		Cursor c= mydatabase.query(TABLENAME_1,new String[] {KEY_CustTerritorySerialNumber,KEY_FirstName,KEY_LastName,
				KEY_TelephoneNumber,KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id,KEY_Address,KEY_StreetNumber,
				KEY_BuildingNumber,KEY_DoorNumber,KEY_FloorNumber,KEY_LandMark,KEY_DeliveryDescription}, KEY_CellPhoneNumber + "= '" + cellphonenumber + "'", null, null, null, null);
		
		 int territorynumber=c.getColumnIndex(KEY_CustTerritorySerialNumber);
		 int firstname=c.getColumnIndex(KEY_FirstName);
		 int lastname=c.getColumnIndex(KEY_LastName);
		 int telephonenumber=c.getColumnIndex(KEY_TelephoneNumber);
		 int cellnumber=c.getColumnIndex(KEY_CellPhoneNumber);
		 int company=c.getColumnIndex(KEY_CompanyName);
		 int emailid=c.getColumnIndex(KEY_Email_id);
		 int address=c.getColumnIndex(KEY_Address);
		 int streetnumber=c.getColumnIndex(KEY_StreetNumber);
		 int buildingnymber=c.getColumnIndex(KEY_BuildingNumber);
		 int doornumber=c.getColumnIndex(KEY_DoorNumber);
		 int floornumber=c.getColumnIndex(KEY_FloorNumber);
		 int landnumber=c.getColumnIndex(KEY_LandMark);
		 int delidesription=c.getColumnIndex(KEY_DeliveryDescription);
		
		 if (c.moveToFirst())
	        {
	            do {      
	            	customerdetails.add(c.getString(territorynumber));
	    			customerdetails.add(c.getString(firstname));
	    			customerdetails.add(c.getString(lastname));
	    			customerdetails.add(c.getString(telephonenumber));
	    			customerdetails.add(c.getString(cellnumber));
	    			customerdetails.add(c.getString(company));
	    			customerdetails.add(c.getString(emailid));
	    			customerdetails.add(c.getString(address));
	    			customerdetails.add(c.getString(streetnumber));
	    			customerdetails.add(c.getString(buildingnymber));
	    			customerdetails.add(c.getString(doornumber));
	    			customerdetails.add(c.getString(floornumber));
	    			customerdetails.add(c.getString(landnumber));
	    			customerdetails.add(c.getString(delidesription));
	            } while (c.moveToNext());
	           
	        }
	        c.close();
		
	 	return customerdetails;	
	}

public  Cursor getCustomerDetailsByName(String name){
		

		return mydatabase.query(TABLENAME_1,new String[] {KEY_Name,
				KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id}, KEY_Name + "= '" + name + "'", null, null, null, null);
		
	
	}
public Cursor getAllCustomerDetailsByCompany(String company) {
	return mydatabase.query(true, TABLENAME_1, new String[] { KEY_Name,
			KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id }, KEY_CompanyName + " LIKE ?",
            new String[] {"%"+ company+ "%" }, null, null, null,
            null);
	 
	
}
public Cursor getAllCustomerDetailsByCellPhoneNumber(String cellPhoneNumber) {
	return mydatabase.query(true, TABLENAME_1, new String[] { KEY_Name,
			KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id }, KEY_CellPhoneNumber + " LIKE ?",
            new String[] {"%"+ cellPhoneNumber+ "%" }, null, null, null,
            null);
	 
	
}
public  Cursor getAllCustomerDetailsByName(String name){
		
	 
	
	Cursor c= mydatabase.query(true, TABLENAME_1, new String[] { KEY_Name,
			KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id }, KEY_Name + " LIKE ?",
            new String[] {"%"+ name+ "%" }, null, null, null,
            null);
	 
	
	 return c;

}
public Cursor getAllCustomerDetailsByCellPhoneNumberAndCompany(String cellPhoneNumber,String company) {
	
	return mydatabase.query(true, TABLENAME_1, new String[] { KEY_Name,
			KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id }, KEY_CellPhoneNumber + " LIKE ?"+" AND "+KEY_CompanyName+" LIKE ?",
            new String[] {"%"+ cellPhoneNumber+ "%","%"+company+"%" }, null, null, null,
            null);
	
}
public Cursor getAllCustomerDetailsByNameAndCompany(String name,String company) {
	
	return mydatabase.query(true, TABLENAME_1, new String[] { KEY_Name,
			KEY_CellPhoneNumber,KEY_CompanyName,KEY_Email_id }, KEY_Name + " LIKE ?"+" AND "+KEY_CompanyName+" LIKE ?",
            new String[] {"%"+ name+ "%","%"+company+"%" }, null, null, null,
            null);
	
}

}
