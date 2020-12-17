package com.koteswara.serveyapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment implements OnClickListener{
	RatingBar ratingbar;
	private TextView txtRatingValue;
	private Button btnSubmit,btnExcel,btnCsv;
	/*public static final String KEY_feedbackSerialNumber = "feedbackserialnumber";
	public static final String KEY_PhoneNumber = "phonenumber";
	public static final String KEY_question1 = "question1";
	public static final String KEY_question2 = "question2";
	public static final String KEY_qiestion3 = "qiestion3";
	public static final String KEY_rating = "rating";
	public static final String KEY_feedtext = "feedtext";*/
	
	String Tag="ThirdFragment";
	String s_productsdidyoubuy,s_cosiderperchasing,s_promotetopurchase,et_s_specify;
	EditText et_et_liquor, et_et_tobaco, et_et_perfumery,et_et_chocolates; 
	ImageButton imageButton_read_thirdpage;
	RadioGroup rg_productsdidyoubuy,rg_cosiderperchasing,rg_promotetopurchase;
	ServeySessionManager ssm3;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View v = inflater.inflate(R.layout.page3, container, false);
		
		rg_productsdidyoubuy= (RadioGroup) v.findViewById(R.id.radio_group_q4);
		rg_cosiderperchasing= (RadioGroup) v.findViewById(R.id.radio_group_q5);
		rg_promotetopurchase= (RadioGroup) v.findViewById(R.id.radio_group_q6);
			 
			 
			 
		et_et_liquor=(EditText) v.findViewById(R.id.et_liquor);
		et_et_tobaco= (EditText) v.findViewById(R.id.et_tobacco);
		et_et_perfumery= (EditText) v.findViewById(R.id.et_perfume);
		et_et_chocolates= (EditText) v.findViewById(R.id.et_chocolates);
			 
		imageButton_read_thirdpage=(ImageButton) v.findViewById(R.id.b_read_third_page);
		imageButton_read_thirdpage.setOnClickListener(this);
		 ssm3=new ServeySessionManager(getActivity());
		rg_productsdidyoubuy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					
					switch (checkedId) {
					case R.id.rb_liqor:
						s_productsdidyoubuy="Liquor";
						et_s_specify=et_et_liquor.getText().toString();
						s_productsdidyoubuy=s_productsdidyoubuy+" "+et_s_specify;
						ssm3.createServeySessionQ4(s_productsdidyoubuy);
						Log.i(Tag, ""+s_productsdidyoubuy);
						
						
						break;
					case R.id.rb_tobacco:
						s_productsdidyoubuy="Tobacco";
						et_s_specify=et_et_tobaco.getText().toString();
						s_productsdidyoubuy=s_productsdidyoubuy+"("+et_s_specify+")";
						ssm3.createServeySessionQ4(s_productsdidyoubuy);
						Log.i(Tag, ""+s_productsdidyoubuy);
						
						break;
					case R.id.rb_perfume:
						s_productsdidyoubuy="Perfumery";
						et_s_specify=et_et_perfumery.getText().toString();
						s_productsdidyoubuy=s_productsdidyoubuy+"("+et_s_specify+")";
						ssm3.createServeySessionQ4(s_productsdidyoubuy);
						Log.i(Tag, ""+s_productsdidyoubuy);
					
						
						break;
					case R.id.rb_chocolates:
						s_productsdidyoubuy="Chocolates";
						et_s_specify=et_et_chocolates.getText().toString();
						s_productsdidyoubuy=s_productsdidyoubuy+"("+et_s_specify+")";
						ssm3.createServeySessionQ4(s_productsdidyoubuy);
						Log.i(Tag, ""+s_productsdidyoubuy);			
						break;
					

					
					}
				}
			});
		rg_cosiderperchasing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					int id1=0;
					switch (checkedId) {
					case R.id.rb_toiletries:
						s_cosiderperchasing="Toiletries";
						Log.i(Tag, ""+s_cosiderperchasing);
						
						break;
					case R.id.rb_babyproducts:
						s_cosiderperchasing="Baby Products";
						ssm3.createServeySessionQ5(s_cosiderperchasing);
						Log.i(Tag, ""+s_cosiderperchasing);			
						break;
					case R.id.rb_perfume_wellness_pro:
						s_cosiderperchasing="Pharmacy & Wellness Products";
						ssm3.createServeySessionQ5(s_cosiderperchasing);
						Log.i(Tag, ""+s_cosiderperchasing);
						
						break;
					case R.id.rb_household:
						s_cosiderperchasing="House Hold items (Air fresh, washing, Dish wash)";
						ssm3.createServeySessionQ5(s_cosiderperchasing);
						Log.i(Tag, ""+s_cosiderperchasing);			
						break;
					case R.id.rb_food:
						s_cosiderperchasing="Food (olive oils, Gourmet canned products, Milk Powder, Tin Juices)";
						ssm3.createServeySessionQ5(s_cosiderperchasing);
						Log.i(Tag, ""+s_cosiderperchasing);			
						break;
					

					
					}
				}
			});
		rg_promotetopurchase.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					int id1=0;
					switch (checkedId) {
					case R.id.rb_quality:
						s_promotetopurchase="Quality  as compared to Downtown";
						ssm3.createServeySessionQ6(s_promotetopurchase);
						Log.i(Tag, ""+s_promotetopurchase);
						
						break;
					case R.id.rb_no:
						s_promotetopurchase="Price as compared to Downtown ";
						ssm3.createServeySessionQ6(s_promotetopurchase);
						Log.i(Tag, ""+s_promotetopurchase);			
						break;
					
					}
				}
			});
	   
	    return v;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		/*Log.i(Tag, ""+s_productsdidyoubuy+""+""+et_s_specify);
		Log.i(Tag,""+s_cosiderperchasing);
		Log.i(Tag, ""+s_promotetopurchase);*/
		
		
		
		
		
		imageButton_read_thirdpage.setBackgroundResource(R.drawable.check);
		
	}

	/*

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.submit:
			Log.i("submit", "inside third");
			ServeySessionManager ssm=new ServeySessionManager(getActivity());
			HashMap<String, String> ss=ssm.getServeySessionDetails();
			String s_q1=ss.get("q1");
			String s_q2=ss.get("q2");
			String s_q3=ss.get("q3");
			String s_q4=ss.get("text");
			String s_q5=ss.get("star");
			Log.i("Q1", s_q1);
			Log.i("Q2", s_q2);
			Log.i("Q3", s_q3);
			Log.i("Q4", s_q4);
			Log.i("Q5", s_q5);
			Log.i("submit", "After session");
			DataHelper dataHelper=new DataHelper(getActivity());
			dataHelper.open();
			dataHelper.addFeedBack(s_q1,s_q2,s_q3,s_q4,s_q5);
			dataHelper.close();
			break;
		case R.id.exportexcel:
			DataHelper dataHelper1=new DataHelper(getActivity());
			dataHelper1.open();
			Cursor c=dataHelper1.getCustomerFeedback();
		
			ArrayList<String> customerdetails= new ArrayList<String>();
		
			 int firstname=c.getColumnIndex(KEY_question1);
			 int lastname=c.getColumnIndex(KEY_question2);
			 int telephonumber=c.getColumnIndex(KEY_qiestion3);
			 int cellnumber=c.getColumnIndex(KEY_feedtext);
			 int cellnumber1=c.getColumnIndex(KEY_rating);
			 if (c.moveToFirst())
		        {
		            do {      
		            	
		    			customerdetails.add(c.getString(firstname));
		    			customerdetails.add(c.getString(lastname));
		    			customerdetails.add(c.getString(telephonumber));
		    			customerdetails.add(c.getString(cellnumber));
		    			customerdetails.add(c.getString(cellnumber1));
		    			
		            } while (c.moveToNext());
		           
		        }
				dataHelper1.close();
		        Log.i("insideexcel", ""+customerdetails);
			break;
		case R.id.exportcsv:
			ServeySessionManager ssm1=new ServeySessionManager(getActivity());
			ssm1.logoutUser();
			exportDB();
			break;

		
		}
	}
	private void exportDB() {

        File dbFile=getActivity().getDatabasePath("customerfeedback.db");
        DataHelper dbhelper = new DataHelper(getActivity());
        File exportDir = new File("/sdcard/download", "csvfeedback");
       
        if (!exportDir.exists())
        {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "feedback.csv");
       
        try
        {
        	// FileWriter f = new FileWriter("/sdcard/download/possible.txt");
            file.createNewFile();
            au.com.bytecode.opencsv.CSVWriter csvWrite = new au.com.bytecode.opencsv.CSVWriter(new FileWriter( file));
           
            dbhelper=new DataHelper(getActivity());
            dbhelper.open();
         
            Cursor curCSV = dbhelper.getCustomerFeedback();
            csvWrite.writeNext(curCSV.getColumnNames());
            while(curCSV.moveToNext())
            {
                //Which column you want to exprort
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
            dbhelper.close();
        }
        catch(Exception sqlEx)
        {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }*/

}
	

