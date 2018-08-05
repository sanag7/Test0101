package com.ebookfrenzy.calculator3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest extends Activity {
    TextView timeTextView;
    String mMonthList[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",  "Oct", "Nov", "Dec"};
    Timer timeTimer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        timeTextView = (TextView)findViewById(R.id.timeView);
        timeTimer = new Timer();
        timeTimer.schedule(timeTimerTask, 30, 1000);
    }

    TimerTask timeTimerTask = new TimerTask(){
        public void run(){
            Calendar calendar = Calendar.getInstance(Locale.KOREA);
            Date date = calendar.getTime();
            String timeAmPm = "";
            if(calendar.get(Calendar.AM_PM) == 0)
                timeAmPm= "am";
            else{
                timeAmPm= "pm";
                if(12 < calendar.get(Calendar.HOUR_OF_DAY));
                //    calendar.set(Calendar.HOUR_OF_DAY - 12);
            }

            final String time = mMonthList[Calendar.MONTH] + " " + String.valueOf(Calendar.DAY_OF_MONTH) + " " + String.valueOf(Calendar.HOUR_OF_DAY) + ":" + String.valueOf(Calendar.MINUTE) + timeAmPm;

            Handler timeHandler = timeTextView.getHandler();
            timeHandler.post(new Runnable(){
                public void run(){
                    Log.d("timeTimerTask", "Time : " + time);
                    timeTextView.setText(time);
                }
            });
        }
    };

    protected void onStop() {
        timeTimerTask.cancel();
        timeTimer.cancel();
        super.onStop();
    }
}

