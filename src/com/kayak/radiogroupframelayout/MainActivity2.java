package com.kayak.radiogroupframelayout;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class MainActivity2 extends FragmentActivity
	implements OnCheckedChangeListener,OnPageChangeListener{
	
	private ViewPager viewPager;
	private RadioGroup radioGroup;
	private Fragment01 fragment01;
	private Fragment02 fragment02;
	private Fragment03 fragment03;
	private Fragment04 fragment04;
	private List<Fragment> fragments;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main2);
		
		fragments = new ArrayList<Fragment>();
		fragment01 = new Fragment01();
		fragment02 = new Fragment02();
		fragment03 = new Fragment03();
		fragment04 = new Fragment04();
		fragments.add(fragment01);
		fragments.add(fragment02);
		fragments.add(fragment03);
		fragments.add(fragment04);
		
		viewPager = (ViewPager) findViewById(R.id.viewpage);
		FragmentManager fm = getSupportFragmentManager();
		ViewPagerAdapter adapter = new ViewPagerAdapter(fm, fragments);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
		radioGroup = (RadioGroup) findViewById(R.id.main_rg);
		radioGroup.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rb0:
			viewPager.setCurrentItem(0);
			break;
		case R.id.rb1:
			viewPager.setCurrentItem(1);
			break;
		case R.id.rb2:
			viewPager.setCurrentItem(2);
			break;
		case R.id.rb3:
			viewPager.setCurrentItem(3);
			break;
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			if (radioGroup.getCheckedRadioButtonId() != R.id.rb0) {
				radioGroup.check(R.id.rb0);
			}
			break;
		case 1:
			if (radioGroup.getCheckedRadioButtonId() != R.id.rb1) {
				radioGroup.check(R.id.rb1);
			}
			break;
		case 2:
			if (radioGroup.getCheckedRadioButtonId() != R.id.rb2) {
				radioGroup.check(R.id.rb2);
			}
			break;
		case 3:
			if (radioGroup.getCheckedRadioButtonId() != R.id.rb3) {
				radioGroup.check(R.id.rb3);
			}
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {
		// TODO Auto-generated method stub
		
	}
	
}
