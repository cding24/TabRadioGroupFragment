package com.kayak.radiogroupframelayout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener{

	private FragOperManager manager;
	private RadioGroup rg;
	private Fragment01 fragment01;
	private Fragment02 fragment02;
	private Fragment03 fragment03;
	private Fragment04 fragment04;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragment01 = new Fragment01();
		fragment02 = new Fragment02();
		fragment03 = new Fragment03();
		fragment04 = new Fragment04();
		manager = new FragOperManager(this, R.id.fragment_container);
		manager.chReplaceFrag(fragment01, "fragment01", false);
		rg = (RadioGroup) findViewById(R.id.main_rg);
		rg.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb0:
			manager.chReplaceFrag(fragment01, "fragment01", false);
			break;
		case R.id.rb1:
			manager.chReplaceFrag(fragment02, "fragment02", false);
			break;
		case R.id.rb2:
			manager.chReplaceFrag(fragment03, "fragment03", false);
			break;
		case R.id.rb3:
			manager.chReplaceFrag(fragment04, "fragment04", false);
			break;
		}
	}

	private float startx;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		super.onTouchEvent(event);
		RadioButton rb0 = (RadioButton) findViewById(R.id.rb0);
		RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
		RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
		RadioButton rb3 = (RadioButton) findViewById(R.id.rb3);
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startx = event.getX();
			break;
		case MotionEvent.ACTION_UP:
			float endx = event.getX();
			if (startx - endx > 100) {//右边
				switch (rg.getCheckedRadioButtonId()) {
				case R.id.rb0:
					rb1.performClick();
					break;
				case R.id.rb1:
					rb2.performClick();
					break;
				case R.id.rb2:
					rb3.performClick();
					break;
				case R.id.rb3:
					rb0.performClick();
					break;
				}
			}else if (endx - startx > 100 ) {
				switch (rg.getCheckedRadioButtonId()) {
				case R.id.rb0:
					rb3.performClick();
					break;
				case R.id.rb1:
					rb0.performClick();
					break;
				case R.id.rb2:
					rb1.performClick();
					break;
				case R.id.rb3:
					rb2.performClick();
					break;
				}
			}			
			break;
		}
		return false;
	}
	
}
