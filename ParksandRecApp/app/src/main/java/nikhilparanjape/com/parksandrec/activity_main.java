package nikhilparanjape.com.parksandrec;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.graphics.Color;
import android.view.MenuItem;
import nikhilparanjape.com.parksandrec.CheckNetwork;


public class activity_main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getActionBar();
        bar.setTitle("Parks and Rec");

        try{
            if(!CheckNetwork.isInternetAvailable(activity_main.this)){
                TextView t = (TextView)findViewById(R.id.alertDisplay);
                t.setTextColor(Color.RED);
                t.setText("Alert! No Internet Connection!");
            }
        }catch(Exception e){
            TextView t = (TextView)findViewById(R.id.alertDisplay);
            t.setText("Error");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
