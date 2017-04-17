package android.alex.edu.moreimplicitentents;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)findViewById(R.id.tpAllarm);
        //timePicker.setCurrentHour(0);
        //timePicker.setCurrentMinute(0);

        Intent intent = getIntent();
        if(intent != null)
        {
            int hour = intent.getIntExtra(AlarmClock.EXTRA_HOUR, 0);
            int minutes = intent.getIntExtra(AlarmClock.EXTRA_MINUTES, 0);
            timePicker.setCurrentHour(hour);
            timePicker.setCurrentMinute(minutes);

            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        }
    }

    public void setAlarm(View view)
    {   int hour = 0;
        int minutes = 0;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            hour =  timePicker.getHour();
            minutes = timePicker.getMinute();
        }
        else
        {
            hour =  timePicker.getCurrentHour();
            minutes = timePicker.getCurrentMinute();
        }

        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);

        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE,  "Good Morning!");
        //alarmIntent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        if(IntentUtils.canOpen(alarmIntent, getPackageManager()));
        {
            startActivity(alarmIntent);
        }
    }
}
