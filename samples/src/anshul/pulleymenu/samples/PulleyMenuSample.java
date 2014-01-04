package anshul.pulleymenu.samples;

import java.util.ArrayList;

import anshul.pulleymenu.R;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Sample class illustrating how to add a menu drawer above the content area.
 */
public class PulleyMenuSample extends Activity implements
		OnItemClickListener {


	anshul.pulleymenu.PulleyMenu pulleymenu;
	
	ListView menuview;
Chronometer stopwatch;
TextView tvtimer;
	int countup,temp,counter;
	@Override
	protected void onCreate(Bundle inState) {
		super.onCreate(inState);
		setContentView(R.layout.activity_topmenu);
    Setuppulleymenu();
	tvtimer = (TextView) findViewById(R.id.tvtimer);
	stopwatch = (Chronometer) findViewById(R.id.chrono1);





	}
	



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		stopwatch.setOnChronometerTickListener(new OnChronometerTickListener() {
			@Override
			public void onChronometerTick(Chronometer arg0) {

				int countup = (int) ((SystemClock.elapsedRealtime() - arg0
						.getBase()) / 1000);
				String asText = (countup / 60) + ":" + (countup % 60);
				tvtimer.setText("Time Elapsed :- " + asText);
			}
		});
	}




	private void Setuppulleymenu() {
		// TODO Auto-generated method stub
		final ListView menuview = new ListView(this);
		menuview.setPadding(0, 30 , 0, 0);
		ArrayList<String> list = new ArrayList<String>();
		list.add("Start");
		list.add("Stop");
		list.add("Reset");

		anshul.pulleymenu.CustomListViewAdapter adapter = new anshul.pulleymenu.CustomListViewAdapter(this,
				android.R.layout.simple_list_item_1, list);
		menuview.setAdapter(adapter);
		menuview.setOnItemClickListener(this);
		int color1 = Color.WHITE;
		int color2 = Color.argb(255, 50, 255, 255);
		pulleymenu = new anshul.pulleymenu.PulleyMenu(this,R.layout.activity_topmenu,menuview,color1,color2);

	}



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
switch (arg2){
		case 1:		
			stopwatch.setBase(SystemClock.elapsedRealtime() + temp);
			stopwatch.start();
			Toast.makeText(this, "Start Called", Toast.LENGTH_LONG).show();
			break;
		case 2:
			temp = (int) (stopwatch.getBase() - SystemClock.elapsedRealtime());
			stopwatch.stop();
			stopwatch.stop();
			counter = counter + countup;
			Toast.makeText(this, "Stop Called", Toast.LENGTH_LONG).show();

			break;
		case 3:
			tvtimer.setText("Time Elapsed :- 0:0 " );
			temp =0;
			Toast.makeText(this, "Reset Called", Toast.LENGTH_LONG).show();
			break;
}
		
	}




}
