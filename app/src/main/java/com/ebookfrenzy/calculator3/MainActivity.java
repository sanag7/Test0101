package com.ebookfrenzy.calculator3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView result = (TextView) findViewById(R.id.result);
        ImageButton nextButton = (ImageButton) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              String result1 = result.getText().toString();
                                              Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                                              intent.putExtra("result", result1);
                                              startActivity(intent);
                                          }
                                      }
        );

    }

    public void addClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(number1.getText().toString());
        double n2 = Double.parseDouble(number2.getText().toString());
        result.setText(String.valueOf(n1 + n2));
    }

    //public void addClick(int v){

    //   int i=0;
    //    String str = addString(i);
    //    int result = addString(i);
    //}

    public void subtractClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(number1.getText().toString());
        double n2 = Double.parseDouble(number2.getText().toString());
        result.setText(String.valueOf(n1 - n2));
    }

    public void multiplyClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(number1.getText().toString());
        double n2 = Double.parseDouble(number2.getText().toString());
        result.setText(String.valueOf(n1 * n2));
    }

    public void devideClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(number1.getText().toString());
        double n2 = Double.parseDouble(number2.getText().toString());
        result.setText(String.valueOf(n1 / n2));
    }
}
