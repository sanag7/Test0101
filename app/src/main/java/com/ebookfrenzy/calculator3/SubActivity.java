package com.ebookfrenzy.calculator3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SubActivity extends AppCompatActivity {

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

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
        Date currentTime = new Date();
        String dTime = formatter.format(currentTime);
//        System.out.println ( dTime );

//        long time = System.currentTimeMillis();
        TextView timeText = (TextView) findViewById(R.id.timeView);
//        String
        timeText.setText(dTime);
    }}

  //  @Override
  //  protected void onCreate(Bundle bundle){
  //          super .onCreate(bundle);
  //          setContentView(R.layout.sub);
   //         ViewPager = (ViewPager) findViewById(R.id.view_pager);
    //        adapter = new Adapter(this);
      //      viewPager.setAdapter(adapter); }