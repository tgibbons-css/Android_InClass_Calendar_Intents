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

        // get the data passed from the main activity using extras
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
            // grab the event number as a string from the main activity using extras
		    eventNum = extras.getString("eventNum");
		}
		//depending on the event number, display different information on this form
		if (eventNum.equals("1")) {
			tvTitle.setText("Thistles & Shamrocks");
			tvSum.setText("An Evening of Scottish & Irish Music and Dance sponsored by the Duluth Scottish Heritage Association -Steve Hand playing the Irish Whistle -DSHA Pipes & Drums band -Erianna Macpherson Reyelts -Scottish Fiddler Mary MacGillivray -DSHA Dancers -And More! Reception following the performance");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, MARCH 4, 2016, 7 P.M.");
		}
		if (eventNum.equals("2")) {
			tvTitle.setText("Why Civil Resistance Works with Erica Chenoweth");
			tvSum.setText("Erica Chenoweth, Ph.D., is an associate professor at the Josef Korbel School of International Studies at the University of Denver and an associate senior researcher at the Peace Research Institute of Oslo.\n" +
					"\n" +
					"An internationally recognized authority on political violence and its alternatives, Foreign Policy magazine ranked her among the Top 100 Global Thinkers in 2013 for her efforts to promote the empirical study of civil resistance.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("THURSDAY, MARCH 10, 2016, 7:30 P.M.");
		}
		if (eventNum.equals("3")) {
			tvTitle.setText("Haydn, The Prince and Baryton");
			tvSum.setText("Haydn wrote more than 120 works of chamber music to satisfy the passion Prince Nikolaus Esterhazy had for playing his beloved baryton. Tonight we offer a rare opportunity to hear this unusual stringed-instrument. Penny Schwarze, baryton, will be joined by Ron Kari, viola, and Betsy Husby, cello, in a performance of charming trios composed for the Prince’s pleasure. The program will also include one of Haydn's piano trios, featuring LeAnn House performing on a replica of an 18th-century piano.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("SATURDAY, MARCH 12, 2016, 7:30 P.M.");
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
			calIntent.putExtra(Events.TITLE, "Thistles & Shamrocks");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2016, 3, 4, 7, 00);
			GregorianCalendar endDate = new GregorianCalendar(2015, 3, 4, 9, 00);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("2")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Why Civil Resistance Works with Erica Chenoweth");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
            GregorianCalendar begDate = new GregorianCalendar(2016, 3, 10, 7, 30);
            GregorianCalendar endDate = new GregorianCalendar(2016, 3, 10, 9, 30);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    begDate.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("3")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Haydn, The Prince and Baryton");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
            GregorianCalendar begDate = new GregorianCalendar(2015, 3, 12, 7, 30);
            GregorianCalendar endDate = new GregorianCalendar(2015, 3, 12, 9, 30);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    begDate.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    endDate.getTimeInMillis());
			startActivity(calIntent);

		}
		

	}
	

}
