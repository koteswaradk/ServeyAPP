package com.koteswara.serveyapp;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportActivity extends FragmentActivity implements OnClickListener{
	ImageButton export_excel,export_csv;
	 CustomerServeyDataHelper dbhelper;
	
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.export);
		export_csv=(ImageButton) findViewById(R.id.exportcsv);
		export_excel=(ImageButton) findViewById(R.id.exportexcel);
		export_csv.setOnClickListener(this);
		export_excel.setOnClickListener(this);
	}
	private void exportToExcel() {		
		final String fileName = "CustomerFeedBack.xls";
		   dbhelper = new CustomerServeyDataHelper(this);
		//Saving file in external storage
		File sdCard = Environment.getExternalStorageDirectory();	
		File directory = new File(sdCard.getAbsolutePath() + "/CustomerFeedBack");
			
		//create directory if not exist
		if(!directory.isDirectory()){
			directory.mkdirs();	
		}
			
		//file path
		File file = new File(directory, fileName);
		
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));		
		WritableWorkbook workbook;
			
		try {
			workbook = Workbook.createWorkbook(file, wbSettings);			
			//Excel sheet name. 0 represents first sheet
			WritableSheet sheet = workbook.createSheet("CustomerFeedBack", 0);

			try {
				sheet.addCell(new Label(0, 0, "feedbackserialnumber")); // column and row
				sheet.addCell(new Label(1, 0, "date"));
				sheet.addCell(new Label(2, 0, "location"));
				sheet.addCell(new Label(3, 0, "nationality"));
				sheet.addCell(new Label(4, 0, "prefession"));
				sheet.addCell(new Label(5, 0, "airline"));
				sheet.addCell(new Label(6, 0, "arrivingfrom"));
				sheet.addCell(new Label(7, 0, "gender"));
				sheet.addCell(new Label(8, 0, "agegroup"));
				sheet.addCell(new Label(9, 0, "purpousoftravel"));
				sheet.addCell(new Label(10, 0, "frequencyoftravel"));
				sheet.addCell(new Label(11, 0, "awareofdutyfreeship"));
				sheet.addCell(new Label(12, 0, "whatproductyoubuy"));
				sheet.addCell(new Label(13, 0, "considerpurchasing"));
				sheet.addCell(new Label(14, 0, "promotetopurchase"));
				sheet.addCell(new Label(15, 0, "rateexpondutyfreeship"));
				sheet.addCell(new Label(16, 0, "rateexponthisairport"));
				
				 dbhelper.open();
				Cursor curxl = dbhelper.getCustomerFeedback();
				if (curxl.moveToFirst()) {
					do {
						String c1 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_FeedbackSerialNumber));
						String c2 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Date));
						String c3 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Location));
						String c4 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Nationality));
						String c5 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Profession));
						String c6 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Airline));
						String c7 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Arrivingfrom));
						String c8 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_Gender));
						String c9 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_AgeGroup));
						String c10 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_PurpousOfTravel));
						String c11 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_FrequencyOfTravel));
						String c12 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_AwareOfDutyFreeShip));
						String c13 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_WhatProductYouBuy));
						String c14 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_ConsiderPurchasing));						
						String c15 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_PromoteToPurchase));
						String c16 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_RateExpOnDutyFreeship));
						String c17 = curxl.getString(curxl.getColumnIndex(CustomerServeyDataHelper.KEY_RateExpOnThisAirport));
						

						int i = curxl.getPosition() + 1;						
						sheet.addCell(new Label(0, i, c1));
						sheet.addCell(new Label(1, i, c2));	
						sheet.addCell(new Label(2, i, c3));
						sheet.addCell(new Label(3, i, c4));
						sheet.addCell(new Label(4, i, c5));
						sheet.addCell(new Label(5, i, c6));
						sheet.addCell(new Label(6, i, c7));
						sheet.addCell(new Label(7, i, c8));
						sheet.addCell(new Label(8, i, c9));
						sheet.addCell(new Label(9, i, c10));
						sheet.addCell(new Label(10, i, c11));
						sheet.addCell(new Label(11, i, c12));
						sheet.addCell(new Label(12, i, c13));
						sheet.addCell(new Label(13, i, c14));
						sheet.addCell(new Label(14, i, c15));
						sheet.addCell(new Label(15, i, c16));
						sheet.addCell(new Label(16, i, c17));
					
					} while (curxl.moveToNext());
				}
				workbook.write();
				//closing cursor
				
				curxl.close();					
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}			
					
			try {
				workbook.close();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void exportDBToCSV() {
		final String fileName = "CustomerFeedBack.csv";
        File dbFile=getDatabasePath("customerfeedback.db");
        CustomerServeyDataHelper dbhelper = new CustomerServeyDataHelper(this);
        File sdCard = Environment.getExternalStorageDirectory();	
		File directory = new File(sdCard.getAbsolutePath() + "/CustomerFeedBackCSV");
       // File exportDir = new File("/sdcard/download", "csvfeedback");
       
        
        if (!directory.exists())
        {
        	directory.mkdirs();
        }

        File file = new File(directory, "feedback.csv");
       
        try
        {
        	// FileWriter f = new FileWriter("/sdcard/download/possible.txt");
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter( file));
           
            
            dbhelper.open();
         
            Cursor curCSV = dbhelper.getCustomerFeedback();
            csvWrite.writeNext(curCSV.getColumnNames());
            while(curCSV.moveToNext())
            {
                //Which column you want to exprort
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),
			                		curCSV.getString(3),curCSV.getString(4), curCSV.getString(5),
			                		curCSV.getString(6),curCSV.getString(7),curCSV.getString(8),
			                		curCSV.getString(9),curCSV.getString(10), curCSV.getString(11),
			                		curCSV.getString(12),curCSV.getString(13), curCSV.getString(14),
			                		curCSV.getString(15), curCSV.getString(16),curCSV.getString(16)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
            dbhelper.close();
        }
        catch(Exception sqlEx)
        {
            Log.e("Export Activity", sqlEx.getMessage(), sqlEx);
        }
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.exportcsv:
			exportDBToCSV();
			break;
		case R.id.exportexcel:
			exportToExcel();
			
			break;

		
		}
	}

}
