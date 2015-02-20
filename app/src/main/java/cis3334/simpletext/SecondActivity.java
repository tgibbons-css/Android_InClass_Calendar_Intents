package cis3334.simpletext;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	String eventNum;		// number of the event from mainActivity
	TextView tvTitle, tvSum, tvLoc, tvDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
		
		tvTitle = (TextView) findViewById(R.id.txtTitle);
		tvSum = (TextView) findViewById(R.id.txtSummary);
		tvLoc = (TextView) findViewById(R.id.txtLocation);
		tvDate = (TextView) findViewById(R.id.txtDate);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    eventNum = extras.getString("eventNum");
		}
		
		if (eventNum.equals("1")) {
			tvTitle.setText("Red Baraat");
			tvSum.setText("Red Baraat has established a reputation as one of the best live bands playing in the world. Led by dhol drummer Sunny Jain, the nine piece band melds the infectious North Indian rhythm Bhangra with a host of sounds, namely funk, go-go, Latin, and jazz.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, FEBRUARY 22, 2013");
		}
		if (eventNum.equals("2")) {
			tvTitle.setText("Billy McLaughlin and His Eclectic String Quartet");
			tvSum.setText("Billy McLaughlin is recognized internationally as a best-selling guitar virtuoso, composer and inspirational performer. In 2001, Billy was diagnosed with focal dystonia, an incurable neuromuscular disease that robbed him of the ability to play his own music.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, March 8, 2013");
		}
		if (eventNum.equals("3")) {
			tvTitle.setText("Battlefield Band");
			tvSum.setText("A bedrock of talent for over four decades,Battlefield Band continue to lead the way for Scotland with their inspired fusion of ancient and modern traditional music and song.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, March 22, 2013");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_second, menu);
		return true;
	}
	
	public void onClickSendText (View v) {
		
		if (eventNum.equals("1")) {
		
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Red Baraat");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2015, 2, 22, 7, 30);
			GregorianCalendar endDate = new GregorianCalendar(2015, 2, 22, 9, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("2")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Billy McLaughlin");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			startActivity(calIntent);
		}
		if (eventNum.equals("3")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Battlefield Band");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(2015, 2, 22, 7, 30);
			Calendar endTime = Calendar.getInstance();
			endTime.set(2015, 2, 22, 9, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					beginTime.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endTime.getTimeInMillis());
			startActivity(calIntent);

		}
		

	}
	

}
