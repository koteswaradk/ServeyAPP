package com.koteswara.serveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFour extends Fragment implements OnClickListener{
	RadioGroup rg_expdutyfreshop,rg_experiencerateinthisairport;
	String Tag="FourFragment";
	String s_expdutyfreshop,s_experiencerateinthisairport,s_et_expdutyfreshop,s_ratingq8;
	ServeySessionManager ssm4;
	EditText et_et_liquor, et_et_tobaco, et_et_perfumery,et_et_chocolates; 
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
	ImageButton im_submit_survey;
	RatingBar ratingbar;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.page4, container, false);
		
		rg_expdutyfreshop= (RadioGroup) v.findViewById(R.id.radio_group_q7);
		rg_experiencerateinthisairport= (RadioGroup) v.findViewById(R.id.radio_group_q8);
		et_et_liquor=(EditText) v.findViewById(R.id.et_q7);
		ratingbar = (RatingBar) v.findViewById(R.id.rating_q8);
		im_submit_survey=(ImageButton)v.findViewById(R.id.submit_survey);
		im_submit_survey.setOnClickListener(this);
		ssm4=new ServeySessionManager(getActivity());
		ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {

				s_ratingq8=String.valueOf(rating);

			}
		});
		rg_expdutyfreshop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				ServeySessionManager ssm=new ServeySessionManager(getActivity());
				
				switch (checkedId) {
				case R.id.rb_product_range:
					s_expdutyfreshop="Product Range";
					s_et_expdutyfreshop=et_et_liquor.getText().toString();
					s_expdutyfreshop=s_expdutyfreshop+"( "+s_et_expdutyfreshop+")";
					ssm4.createServeySessionQ7(s_expdutyfreshop);
					Log.i(Tag, ""+s_expdutyfreshop);
					
					break;
				case R.id.rb_offerpromotion:
					s_expdutyfreshop="Offer & promotion";
					s_et_expdutyfreshop=et_et_liquor.getText().toString();
					s_expdutyfreshop=s_expdutyfreshop+"( "+s_et_expdutyfreshop+")";
					ssm4.createServeySessionQ7(s_expdutyfreshop);
					Log.i(Tag, ""+s_expdutyfreshop);
					
					break;
				case R.id.rb_storage_ambience:
					s_expdutyfreshop="Store ambience";
					s_et_expdutyfreshop=et_et_liquor.getText().toString();
					s_expdutyfreshop=s_expdutyfreshop+"( "+s_et_expdutyfreshop+")";
					ssm4.createServeySessionQ7(s_expdutyfreshop);
					Log.i(Tag, ""+s_expdutyfreshop);
				
					
					break;
				case R.id.rb_customer_service:
					s_expdutyfreshop="Customer Service";
					s_et_expdutyfreshop=et_et_liquor.getText().toString();
					s_expdutyfreshop=s_expdutyfreshop+" ("+s_et_expdutyfreshop+")";
					ssm4.createServeySessionQ7(s_expdutyfreshop);
					Log.i(Tag, ""+s_expdutyfreshop);			
					break;
				

				
				}
			}
		});
		
		rg_experiencerateinthisairport.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				ServeySessionManager ssm=new ServeySessionManager(getActivity());
				int id1=0;
				switch (checkedId) {
				case R.id.rb_immigration:
					s_experiencerateinthisairport="Immigration";
					Log.i(Tag, ""+s_experiencerateinthisairport);
					
					break;
				case R.id.rb_custom:
					s_experiencerateinthisairport="Custom ";
					Log.i(Tag, ""+s_experiencerateinthisairport);			
					break;
				
				}
			}
		});
		return v;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.submit_survey:
			
			
			ssm4.createServeySessionQ8(s_experiencerateinthisairport+" ("+s_ratingq8+")");
			
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			String s_date=dateFormat.format(date);
			
			HashMap<String, String>Cssv=ssm4.getServeySessionDetails();
			String s_q1=Cssv.get(KEY_Location);
			String s_q2=Cssv.get(KEY_Nationality);
			String s_q3=Cssv.get(KEY_Profession);
			String s_q4=Cssv.get(KEY_Airline);
			String s_q5=Cssv.get(KEY_Gender);
			String s_q6=Cssv.get(KEY_ArrivingFrom);
			String s_q7=Cssv.get(KEY_Agegroup);
			String s_q8=Cssv.get(KEY_Q1);
			String s_q9=Cssv.get(KEY_Q2);
			String s_q10=Cssv.get(KEY_Q3);
			String s_q11=Cssv.get(KEY_Q4);
			String s_q12=Cssv.get(KEY_Q5);
			String s_q13=Cssv.get(KEY_Q6);
			String s_q14=Cssv.get(KEY_Q7);
			String s_q15=Cssv.get(KEY_Q8);
			
			Log.i(Tag,""+s_q1);
			Log.i(Tag,""+s_q2);
			Log.i(Tag,""+s_q3);
			Log.i(Tag,""+s_q4);
			Log.i(Tag,""+s_q5);
			Log.i(Tag,""+s_q6);
			Log.i(Tag,""+s_q7);
			Log.i(Tag,""+s_q8);
			Log.i(Tag,""+s_q9);
			Log.i(Tag,""+s_q10);
			Log.i(Tag,""+s_q11);
			Log.i(Tag,""+s_q12);
			Log.i(Tag,""+s_q13);
			Log.i(Tag,""+s_q14);
			Log.i(Tag,""+s_q15);
			Log.i(Tag,""+s_date);
			CustomerServeyDataHelper csdh=new CustomerServeyDataHelper(getActivity());
			csdh.open();
			long value=csdh.addFeedBack(s_date, s_q1, s_q2, s_q3, s_q4, s_q6, s_q5, s_q7, s_q8, s_q9, s_q10, s_q11, s_q12, s_q13, s_q14, s_q15);
			csdh.close();
			if (value!=-1) {
				ssm4.logoutUser();
				getActivity().finish();
				startActivity(new Intent(getActivity(), MainActivity.class));
				Toast.makeText(getActivity(), "Servay Added SuccessFully", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(getActivity(), "Sorry Error in Data Creation", Toast.LENGTH_LONG).show();
			}
			
			
			break;

		
		}
		
	}

}
