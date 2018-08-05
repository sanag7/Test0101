package com.ebookfrenzy.calculator3;

import android.app.Activity;
import android.content.Intent;
import android.media.TimedText;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class SubActivity extends AppCompatActivity {

    TextView timeTextView;
    String mMonthList[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",  "Oct", "Nov", "Dec"};
    Timer timeTimer;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sub);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        Adapter adapter = new Adapter(this.getApplicationContext());
        viewPager.setAdapter(adapter);

        TextView nameText = (TextView) findViewById(R.id.result);
        Intent intent = getIntent();
        nameText.setText(intent.getStringExtra("result").toString());

//        TimeTest timeTest = new TimeTest();

        timeTextView = (TextView)findViewById(R.id.timeView);
        timeTimer = new Timer();
        timeTimer.schedule(timeTimerTask, 30, 1000);

        // Date currentTime = new Date();
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        // String dTime = formatter.format(currentTime);
        // TextView timeText = (TextView) findViewById(R.id.timeView);
        // timeText.setText(dTime);
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
                if(12 < calendar.get(Calendar.HOUR_OF_DAY)){
                    int hours_get = calendar.get(Calendar.HOUR_OF_DAY);
                    calendar.set(Calendar.HOUR_OF_DAY, hours_get - 12);
                }
            }

//            final String time = mMonthList[calendar.get(Calendar.DAY_OF_MONTH)] + " " + date.getDay() + " " + date.getHours() + ":" + date.getMinutes() + timeAmPm;

            final String time2 = mMonthList[calendar.get(Calendar.MONTH)] + " "
                                + calendar.get(Calendar.DAY_OF_MONTH) + " "
                                + String.format("%02d:%02d",calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE))
                                + timeAmPm;

//            final String time3 = String.format("%02d",calendar.get(Calendar.MONTH));

//            Log.d("eee",time3);

            Handler timeHandler = timeTextView.getHandler();
            timeHandler.post(new Runnable(){
                public void run(){
                    Log.d("timeTimerTask", "Time : " + time2);
                    timeTextView.setText(time2);
                }
            });
        }
    };
    int ct;
    Button like;
    TextView likecount;

    Handler mHandler = new Handler(){
        public void handleMessage(Message mgs){
            likecount = (TextView)findViewById(R.id.likecount);
            ct++;
            likecount.setText(ct+"");
            mHandler.sendEmptyMessageDelayed(10, 100);
        }
    };


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setContentView(R.layout.sub);
        like = (Button) findViewById(R.id.like);

        like.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        mHandler.sendMessageDelayed(new Message(),0);
                    }
                }
        );
    }

    public  void mOnClick(View v){
        likecount = (TextView)findViewById(R.id.likecount);
        ct++;
        likecount.setText(ct+"");
        mHandler.removeMessages(10);
    }
}

