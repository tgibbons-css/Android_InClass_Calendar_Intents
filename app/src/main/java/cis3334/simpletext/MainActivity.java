package cis3334.simpletext;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_main, menu);
		return true;
	}
	
    public void onClickB1(View view) {
    	Intent i = new Intent(getApplicationContext(), SecondActivity.class);
    	i.putExtra("eventNum","1");
    	startActivity(i);
    }
    
    public void onClickB2(View view) {
    	Intent i = new Intent(getApplicationContext(), SecondActivity.class);
    	i.putExtra("eventNum","2");
    	startActivity(i);
    }
    
    public void onClickB3(View view) {
    	Intent i = new Intent(getApplicationContext(), SecondActivity.class);
    	i.putExtra("eventNum","3");
    	startActivity(i);
    }

}
