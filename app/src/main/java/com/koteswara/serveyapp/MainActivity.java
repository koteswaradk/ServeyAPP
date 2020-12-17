package com.koteswara.serveyapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainActivity extends FragmentActivity {
	FirstFragment first=null;
	VerticalViewPager pager;
	TextView count;
	int displaycount=0;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.main);
		 pager = (VerticalViewPager) findViewById(R.id.viewPager);
		ImageButton preButton=(ImageButton) findViewById(R.id.preveous);
		ImageButton nextButton=(ImageButton) findViewById(R.id.next);
		//count=(TextView) findViewById(R.id.count);
	        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
	        
	        preButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					pager.setCurrentItem(pager.getCurrentItem() - 1, true);
					displaycount=displaycount+pager.getCurrentItem() - 1;
					//count.setText(Integer.toString(getnextItem(displaycount)));
					
					
				}
			});
	        nextButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					pager.setCurrentItem(pager.getCurrentItem() + 1, true);
					
					displaycount=displaycount + 1;
					//count.setText(Integer.toString(getnextItem(displaycount)));
				}
			});
	}
	private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

		@NonNull
		@Override
		public androidx.fragment.app.Fragment getItem(int position) {
			Fragment fm=new Fragment();
			switch (position){
				case 0:
					fm=new FirstFragment();

					break;
				case 1:
					fm=new SecondFragment();

					break;
				case 2:
					fm=new ThirdFragment();

					break;
				case 3:
					fm=new FragmentFour();

					break;
			}
			return fm;
		}
/*  @Override
        public Fragment getItem(int pos) {
			fm=new Fragment();
            switch(pos) {
            case 0:
            	fm=new FirstFragment();
            	
            	break;
            case 1:
            	fm=new SecondFragment();
            	
            	break;
            case 2:
            	fm=new ThirdFragment();
            	
            	break;
            case 3:
            	fm=new FragmentFour();
            	
            	break;       
        
            }
			 
            return fm;
        }*/

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}
		


}
	private int getnextItem(int i) {
	       return pager.getCurrentItem() + i;
	}
	private int getpreveousItem(int i) {
	       return pager.getCurrentItem() - i;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.export:
            startActivity(new Intent(MainActivity.this, ExportActivity.class));
        	
            
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    
    }
}
