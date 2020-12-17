package com.koteswara.serveyapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment implements OnClickListener{
	String Tag="FirstFragment";
	RadioGroup rg_purposoftravel,rg_frequencyoftravel,rg_awaredutyfreeshopm;
	String s_purposoftravel,s_frequencyoftravel,s_awaredutyfreeshopm;
	ImageButton imageButton_read_secondpage;
	ServeySessionManager ssm2;
@Override
@Nullable
public View onCreateView(LayoutInflater inflater,
		@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	 View v = inflater.inflate(R.layout.page2, container, false);

	    TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);
	    rg_purposoftravel= (RadioGroup) v.findViewById(R.id.radio_group_q1);
	    rg_frequencyoftravel= (RadioGroup) v.findViewById(R.id.radio_group_q2);
	    rg_awaredutyfreeshopm= (RadioGroup) v.findViewById(R.id.radio_group_q3);
		 
		 imageButton_read_secondpage=(ImageButton) v.findViewById(R.id.b_read_second_page);
		 imageButton_read_secondpage.setOnClickListener(this);
		  ssm2=new ServeySessionManager(getActivity());
		 rg_purposoftravel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					
					switch (checkedId) {
					
					case R.id.rb_usiness:
						s_purposoftravel="Business";
						ssm2.createServeySessionQ1(s_purposoftravel);
						Log.i(Tag, s_purposoftravel+"");
					
						break;
					case R.id.rb_leisure:
						s_purposoftravel="Leisure";
						ssm2.createServeySessionQ1(s_purposoftravel);
						Log.i(Tag, s_purposoftravel+"");	
						
						break;
					case R.id.rb_both:
						s_purposoftravel="Both";
						ssm2.createServeySessionQ1(s_purposoftravel);
						Log.i(Tag, ""+s_purposoftravel);			
						break;

					}
				}
			});
		 rg_frequencyoftravel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					int id1=0;
					switch (checkedId) {
					case R.id.rb_1_2_times:
						s_frequencyoftravel="1-2 times";
						ssm2.createServeySessionQ2(s_frequencyoftravel);
						Log.i(Tag, ""+s_frequencyoftravel);
						
						break;
					case R.id.rb_3_5_times:
						s_frequencyoftravel="3-5 times";
						ssm2.createServeySessionQ2(s_frequencyoftravel);
						Log.i(Tag, ""+s_frequencyoftravel);			
						break;
					case R.id.rb_6_10_times:
						s_frequencyoftravel="6-10 times";
						ssm2.createServeySessionQ2(s_frequencyoftravel);
						Log.i(Tag, ""+s_frequencyoftravel);
						
						break;
					case R.id.rb_more_10times:
						s_frequencyoftravel="> 10 times";
						ssm2.createServeySessionQ2(s_frequencyoftravel);
						Log.i(Tag, ""+s_frequencyoftravel);			
						break;
					

					
					}
				}
			});
		 rg_awaredutyfreeshopm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					ServeySessionManager ssm=new ServeySessionManager(getActivity());
					switch (checkedId) {
					case R.id.rb_yes:
						s_awaredutyfreeshopm="Yes";
						ssm2.createServeySessionQ3(s_awaredutyfreeshopm);
						Log.i(Tag, ""+s_awaredutyfreeshopm);	
						break;
					case R.id.rb_no:
						s_awaredutyfreeshopm="No";
						ssm2.createServeySessionQ3(s_awaredutyfreeshopm);
						Log.i(Tag, ""+s_awaredutyfreeshopm);			
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
	case R.id.b_read_second_page:
	
		/*Log.i(Tag, ""+s_awaredutyfreeshopm);
		Log.i(Tag, ""+s_frequencyoftravel);
		Log.i(Tag, ""+s_purposoftravel);*/
		
		
		
		
		
		
		imageButton_read_secondpage.setBackgroundResource(R.drawable.check);
		
		break;

	
	}
	
}

	
}
