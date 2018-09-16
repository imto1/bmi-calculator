package com.behmerd.bmicalculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.magnet.sdk.MagnetMobileBannerAd;


public class AnalyzeActivity extends Activity {

    int height, weight;//, age;
   // boolean isMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        // show ads
        MagnetMobileBannerAd bannerAd = MagnetMobileBannerAd.create(getApplicationContext());
        FrameLayout adLayout = (FrameLayout) findViewById(R.id.mobileBanner);
        bannerAd.load("063718623da4482f9667430479170528", adLayout);
        try {
            if (getIntent().getExtras() != null) {
                weight = Integer.valueOf(getIntent().getExtras().getString("weight"));
                height = Integer.valueOf(getIntent().getExtras().getString("height"));
                //age = Integer.valueOf(getIntent().getExtras().getString("age"));
                //isMale = String.valueOf(getIntent().getExtras().getString("gender")).equals("male");
            }
        }
        catch (Exception e){
            Log.e("bmic","Error on getting extras!");
            finish();
        }

        TextView tvBS = (TextView) findViewById(R.id.tvBodyStatus);
        TextView tvBMI = (TextView) findViewById(R.id.tvBMI);
        TextView tvBW = (TextView) findViewById(R.id.tvBestWeight);
        TextView tvTL = (TextView) findViewById(R.id.tvToLose);
        TextView tvMM = (TextView) findViewById(R.id.tvMinMax);
        TextView tvMMT = (TextView) findViewById(R.id.tvStatus);
        TextView tvTLT = (TextView) findViewById(R.id.tvIndex);
        TextView tvBWT = (TextView) findViewById(R.id.tvBW);
        TextView tvBMIT = (TextView) findViewById(R.id.tvTL);
        TextView tvBST = (TextView) findViewById(R.id.tvMM);
        TextView tvW = (TextView) findViewById(R.id.tvWarn);
        LinearLayout ml = (LinearLayout) findViewById(R.id.mailL);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relL);
        RelativeLayout xl = (RelativeLayout) findViewById(R.id.masterL);
        final ImageView ivBMIBar = (ImageView) findViewById(R.id.ivBMIBar);
        ImageView ivAbout = (ImageView) findViewById(R.id.ivAbout);

        try{
            Typeface boldPersian = Typeface.createFromAsset(getAssets(), "font/BNaznnBd.ttf");
            tvMMT.setTypeface(boldPersian);
            tvTLT.setTypeface(boldPersian);
            tvBWT.setTypeface(boldPersian);
            tvBMIT.setTypeface(boldPersian);
            tvBST.setTypeface(boldPersian);
            Typeface regularPersian = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf");
            tvMM.setTypeface(regularPersian);
            tvTL.setTypeface(regularPersian);
            tvBW.setTypeface(regularPersian);
            tvBMI.setTypeface(regularPersian);
            tvBS.setTypeface(regularPersian);
            tvW.setTypeface(regularPersian);
        }
        catch(Exception e){
            Log.e("bmic","Error on setting typeface!");
        }

        ivAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            }
        });

        //Code.Initialize(age,isMale);
        int bs = Code.bodyStatus(Code.bmiCalculate(height, weight));
        String bodyStatus;

        switch(bs)
        {
            case 0:
                bodyStatus = getString(R.string.bs1);
                ivBMIBar.setImageResource(R.drawable.underweight);
                tvBS.setTextColor(Color.parseColor("#0077ff"));
                tvBMI.setTextColor(Color.parseColor("#0077ff"));
                tvTL.setTextColor(Color.parseColor("#0077ff"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#fffdfdfe"));
                rl.setBackgroundColor(Color.parseColor("#fffdfdfe"));
                xl.setBackgroundColor(Color.parseColor("#fffdfdfe"));
                break;
            case 1:
                bodyStatus = getString(R.string.bs2);
                ivBMIBar.setImageResource(R.drawable.median);
                tvBS.setTextColor(Color.parseColor("#00aa00"));
                tvBMI.setTextColor(Color.parseColor("#00aa00"));
                tvTL.setTextColor(Color.parseColor("#00aa00"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#ffd8fdd8"));
                rl.setBackgroundColor(Color.parseColor("#ffd8fdd8"));
                xl.setBackgroundColor(Color.parseColor("#ffd8fdd8"));
                break;
            case 2:
                bodyStatus = getString(R.string.bs3);
                ivBMIBar.setImageResource(R.drawable.standard);
                tvBS.setTextColor(Color.parseColor("#007700"));
                tvBMI.setTextColor(Color.parseColor("#007700"));
                tvTL.setTextColor(Color.parseColor("#007700"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#ffd9fdd9"));
                rl.setBackgroundColor(Color.parseColor("#ffd9fdd9"));
                xl.setBackgroundColor(Color.parseColor("#ffd9fdd9"));
                break;
            case 3:
                bodyStatus = getString(R.string.bs4);
                ivBMIBar.setImageResource(R.drawable.overweight);
                tvBS.setTextColor(Color.parseColor("#ff5500"));
                tvBMI.setTextColor(Color.parseColor("#ff5500"));
                tvTL.setTextColor(Color.parseColor("#ff5500"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#fffdfdd9"));
                rl.setBackgroundColor(Color.parseColor("#fffdfdd9"));
                xl.setBackgroundColor(Color.parseColor("#fffdfdd9"));
                break;
            case 4:
                bodyStatus = getString(R.string.bs5);
                ivBMIBar.setImageResource(R.drawable.obese);
                tvBS.setTextColor(Color.parseColor("#ff0000"));
                tvBMI.setTextColor(Color.parseColor("#ff0000"));
                tvTL.setTextColor(Color.parseColor("#ff0000"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                rl.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                xl.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                break;
            case 5:
                bodyStatus = getString(R.string.bs6);
                ivBMIBar.setImageResource(R.drawable.obese);
                tvBS.setTextColor(Color.parseColor("#ff0000"));
                tvBMI.setTextColor(Color.parseColor("#ff0000"));
                tvTL.setTextColor(Color.parseColor("#ff0000"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                rl.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                xl.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                break;
            case 6:
                bodyStatus = getString(R.string.bs7);
                ivBMIBar.setImageResource(R.drawable.obese);
                tvBS.setTextColor(Color.parseColor("#ff0000"));
                tvBMI.setTextColor(Color.parseColor("#ff0000"));
                tvTL.setTextColor(Color.parseColor("#ff0000"));
                tvBW.setTextColor(Color.parseColor("#007700"));
                tvMM.setTextColor(Color.parseColor("#007700"));
                ml.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                rl.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                xl.setBackgroundColor(Color.parseColor("#fffdc0c0"));
                break;
            default:
                bodyStatus = getString(R.string.bs8);
                ivBMIBar.setImageResource(R.drawable.underweight);
                tvBS.setTextColor(Color.parseColor("#000000"));
                tvBMI.setTextColor(Color.parseColor("#000000"));
                tvTL.setTextColor(Color.parseColor("#000000"));
                tvBW.setTextColor(Color.parseColor("#000000"));
                tvMM.setTextColor(Color.parseColor("#000000"));
                ml.setBackgroundColor(Color.parseColor("#fffdfdfe"));
                rl.setBackgroundColor(Color.parseColor("#fffdfdfe"));
                xl.setBackgroundColor(Color.parseColor("#fffdfdfe"));
                break;
        }

        try {
            tvBS.setText(bodyStatus);
            tvBMI.setText(String.valueOf(Code.bmiCalculate(height, weight)));
            String bw = Code.getBest(height);
            tvBW.setText(bw);
            tvTL.setText(Code.gotoStd(weight, Code.fix(Float.valueOf(bw), 1)));
            int min, max;
            min = Code.getMinimum(height, Integer.valueOf((int) Code.fix(Float.valueOf(bw),0)));
            max = Code.getMaximum(height, Integer.valueOf((int) Code.fix(Float.valueOf(bw),0)));
            tvMM.setText(String.valueOf(min) + " - " + String.valueOf(max));
        }
        catch(Exception e){
            Log.e("bmic","Error on result representation.");
        }
    }

}
