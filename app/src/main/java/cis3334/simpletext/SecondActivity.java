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
			tvTitle.setText("Katie McMahon’s");
			tvSum.setText("Katie McMahon returns for a celebration of St. Patrick’s Day.  Originally from Dublin, and classically trained in voice and harp, she was a soloist with the original Riverdance troupe. She is joined by a Celtic band and dancers for this evening of everything Irish.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, MARCH 13, 2015");
		}
		if (eventNum.equals("2")) {
			tvTitle.setText("Randall Poole");
			tvSum.setText("Randall A. Poole, Ph.D. is Professor of History at the College of St. Scholastica.  His research areas include Russian and European intellectual history, the history of ideas and the history of philosophical and religious thought.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("THURSDAY, MARCH 26, 2015");
		}
		if (eventNum.equals("3")) {
			tvTitle.setText("Click Clack Moo!");
			tvSum.setText("Cows that type? Hens on strike! Whoever heard of such a thing Farmer Brown cries When his granddaughter Jenny comes for a visit, Farmer Brown declared the farm a \"tech-free zone.\" He confiscates her laptop in the cold barn along with the shivering cows who use her computer to type messages requesting blankets.\n" +
                    "\"No way,\" replies Farmer Brown. \"No blankets!\"");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText(" THURSDAY, FEBRUARY 26, 2015");
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
			calIntent.putExtra(Events.TITLE, "Katie McMahon’s St. Patrick’s Day Party");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2015, 3, 13, 7, 30);
			GregorianCalendar endDate = new GregorianCalendar(2015, 3, 13, 9, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("2")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Randall Poole");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
            GregorianCalendar begDate = new GregorianCalendar(2015, 3, 26, 7, 30);
            GregorianCalendar endDate = new GregorianCalendar(2015, 3, 26, 9, 30);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    begDate.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("3")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Click Clack Moo!d");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
            GregorianCalendar begDate = new GregorianCalendar(2015, 2, 26, 12, 30);
            GregorianCalendar endDate = new GregorianCalendar(2015, 2, 26, 2, 30);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    begDate.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    endDate.getTimeInMillis());
			startActivity(calIntent);

		}
		

	}
	

}
