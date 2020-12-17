package com.koteswara.serveyapp;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements OnClickListener{
	String Tag="FirstFragment";
	String s_location,s_profession,s_gender,s_agegroup,s_nationality,s_airline,s_arrivingfrom;
	EditText et_nationality, et_airline, et_arrvingfrom; 
	ImageButton imageButton_read_firstpage;
	RadioGroup rg_location,rg_profession,rg_gender,rg_agegroup;
	 ServeySessionManager ssm;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View v = inflater.inflate(R.layout.page1, container, false);

		 rg_location= (RadioGroup) v.findViewById(R.id.radio_location);
		 rg_profession= (RadioGroup) v.findViewById(R.id.radio_profession);
		 rg_gender= (RadioGroup) v.findViewById(R.id.radio_gender);
		 rg_agegroup= (RadioGroup) v.findViewById(R.id.radio_agegroup);
		
		 et_nationality=(EditText) v.findViewById(R.id.et_natinality);
		 et_airline= (EditText) v.findViewById(R.id.et_airline);
		 et_arrvingfrom= (EditText) v.findViewById(R.id.et_arivingfrom);
		
		 imageButton_read_firstpage=(ImageButton) v.findViewById(R.id.b_read_first_page);
		 imageButton_read_firstpage.setOnClickListener(this);
		  ssm=new ServeySessionManager(getActivity());
		
		 rg_location.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					
					switch (checkedId) {
					
					case R.id.rb_arrival:
						s_location="Arrival";
						Log.i(Tag, s_location+"");
						s_nationality=et_nationality.getText().toString();
						ssm.createServeySessionlocation(s_location);
						ssm.createServeySessionNationality(s_nationality);
						break;
					case R.id.rb_departure:
						s_location="Departure";
						Log.i(Tag, s_location+"");	
						
						s_nationality=et_nationality.getText().toString();
						ssm.createServeySessionlocation(s_location);
						ssm.createServeySessionNationality(s_nationality);
						
						break;

					}
				}
			});
		 rg_profession.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					int id1=0;
					switch (checkedId) {
					case R.id.rb_Business:
						s_profession="Buisness";
						s_airline=et_airline.getText().toString();
						ssm.createServeySessionProfession(s_profession);
						ssm.createServeySessionAirline(s_airline);
						Log.i(Tag, ""+s_profession);
						
						break;
					case R.id.rb_Employeed:
						s_profession="Employeed";
						s_airline=et_airline.getText().toString();
						ssm.createServeySessionProfession(s_profession);
						ssm.createServeySessionAirline(s_airline);
						Log.i(Tag, ""+s_profession);			
						break;
					

					
					}
				}
			});
		 rg_gender.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					switch (checkedId) {
					case R.id.rb_male:
						s_gender="Male";
						s_arrivingfrom=et_arrvingfrom.getText().toString();
						ssm.createServeySessionGender(s_gender);
						ssm.createServeySessionArrivingfrom(s_arrivingfrom);
						Log.i(Tag, ""+s_gender);	
						break;
					case R.id.rb_female:
						s_gender="Female";
						s_arrivingfrom=et_arrvingfrom.getText().toString();
						ssm.createServeySessionGender(s_gender);
						ssm.createServeySessionArrivingfrom(s_arrivingfrom);
						Log.i(Tag, ""+s_gender);			
						break;
					

					
					}
				}
			});
		 rg_agegroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						ServeySessionManager ssm=new ServeySessionManager(getActivity());
						switch (checkedId) {
						case R.id.rb_age_25_35:
								s_agegroup="25-35";
								ssm.createServeySessionAgegroup(s_agegroup);
							Log.i(Tag, ""+s_agegroup);
							
							break;
						case R.id.rb_age_36_45:
							s_agegroup="36_45";
							ssm.createServeySessionAgegroup(s_agegroup);
							Log.i(Tag, ""+s_agegroup);		
							break;
						case R.id.rb_age_46_54:
							s_agegroup="46_54";
							ssm.createServeySessionAgegroup(s_agegroup);
							Log.i(Tag, ""+s_agegroup);
							break;
						case R.id.rb_age_above_55:
							s_agegroup="Above 55";
							ssm.createServeySessionAgegroup(s_agegroup);
							Log.i(Tag, ""+s_agegroup);
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
		case R.id.b_read_first_page:
			
			
			
			/*Log.i(Tag, ""+s_nationality);
			Log.i(Tag, ""+s_airline);
			Log.i(Tag, ""+s_arrivingfrom);
			Log.i(Tag, ""+s_agegroup);
			Log.i(Tag, ""+s_gender);
			Log.i(Tag,""+s_profession);
			Log.i(Tag, ""+s_location);*/
			
			
			
			
			
			
			imageButton_read_firstpage.setBackgroundResource(R.drawable.check);
			
			
			break;

	
		}
		
	}

}
