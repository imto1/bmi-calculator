package com.behmerd.bmicalculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
//import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import ir.magnet.sdk.MagnetMobileBannerAd;


public class MainActivity extends Activity {

    //boolean isMale = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // show ads
        MagnetMobileBannerAd bannerAd = MagnetMobileBannerAd.create(getApplicationContext());
        FrameLayout adLayout = (FrameLayout) findViewById(R.id.mobileBanner);
        bannerAd.load("063718623da4482f9667430479170528", adLayout);

        final EditText etHeight = (EditText) findViewById(R.id.etHeight);
        final EditText etWeight = (EditText) findViewById(R.id.etWeight);
        final TextView tvHeight = (TextView) findViewById(R.id.tvHeight);
        final TextView tvWeight = (TextView) findViewById(R.id.tvWeight);

        try{
            Typeface boldPersian = Typeface.createFromAsset(getAssets(), "font/BNaznnBd.ttf");
            tvHeight.setTypeface(boldPersian);
            tvWeight.setTypeface(boldPersian);
            Typeface regularPersian = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf");
            etHeight.setTypeface(regularPersian);
            etWeight.setTypeface(regularPersian);
        }
        catch(Exception e){
            Log.e("bmic","Error on setting typeface!");
        }

        /*final TextView tvAge= (TextView) findViewById(R.id.tvAge);
        final EditText etAge= (EditText) findViewById(R.id.etAge);
        RadioButton rb1 = (RadioButton) findViewById(R.id.ro1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.ro2);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMale=false;
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMale=true;
            }
        });*/

        ImageView ivAnalyze = (ImageView) findViewById(R.id.ivCalculate);
        ivAnalyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getApplicationContext(), AnalyzeActivity.class);
                    if ((!etHeight.getText().toString().equals("")) &&
                            (!etWeight.getText().toString().equals("")))/*&&
                            (!etAge.getText().toString().equals("")))*/
                    {
                        if(CHK())
                        {
                            i.putExtra("height", etHeight.getText().toString());
                            i.putExtra("weight", etWeight.getText().toString());
                            //i.putExtra("age", etAge.getText().toString());
                            /*if(isMale)
                                i.putExtra("gender", "male");
                            else
                                i.putExtra("gender", "female");*/
                            tvHeight.setTextColor(Color.parseColor("#000000"));
                            tvWeight.setTextColor(Color.parseColor("#000000"));
                            //tvAge.setTextColor(Color.parseColor("#000000"));
                            tvHeight.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                            tvWeight.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                            //tvAge.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                            startActivity(i);
                        }
                    } else {
                        tvHeight.setTextColor(Color.parseColor("#ff0000"));
                        tvWeight.setTextColor(Color.parseColor("#ff0000"));
                        //tvAge.setTextColor(Color.parseColor("#ff0000"));
                        tvHeight.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        tvWeight.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
                        //tvAge.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        Toast.makeText(getApplicationContext(), getString(R.string.ma_warning), Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception e){
                    Log.e("bmic", "Error on starting activity!");
                }
            }
        });
        ImageView ivAbout = (ImageView) findViewById(R.id.ivAboutm);
        ivAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            }
        });
    }

    private boolean CHK() {
        int height, weight;//, age;
        //EditText etAge = (EditText) findViewById(R.id.etAge);
        EditText etHeight = (EditText) findViewById(R.id.etHeight);
        EditText etWeight = (EditText) findViewById(R.id.etWeight);

        height=Integer.valueOf(etHeight.getText().toString());
        weight=Integer.valueOf(etWeight.getText().toString());
        //age=Integer.valueOf(etAge.getText().toString());

        /*if(age<1) {
            etAge.setTextColor(Color.parseColor("#ff0000"));
            Toast.makeText(getApplicationContext(), getString(R.string.ma_ua), Toast.LENGTH_LONG).show();
            return false;
        }*/

        if(height<65) {
            etHeight.setTextColor(Color.parseColor("#ff0000"));
            Toast.makeText(getApplicationContext(), getString(R.string.ma_b65), Toast.LENGTH_LONG).show();
            return false;
        }

        if(weight<1) {
            etWeight.setTextColor(Color.parseColor("#ff0000"));
            Toast.makeText(getApplicationContext(), getString(R.string.ma_b1), Toast.LENGTH_LONG).show();
            return false;
        }

        //etAge.setTextColor(Color.parseColor("#000000"));
        etHeight.setTextColor(Color.parseColor("#000000"));
        etWeight.setTextColor(Color.parseColor("#000000"));
        return true;
    }

}
