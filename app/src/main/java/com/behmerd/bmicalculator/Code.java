package com.behmerd.bmicalculator;

import java.util.Locale;

public class Code {

    //static float u ,ml ,mh ,nl ,nh ,ol ,oh ,o1l ,o1h ,o2l ,o2h ,o3;
    //static int as;
    //static int bi;

    static float u = (float) 18.4;
    static float ml = (float) 18.5;
    static float mh = (float) 22.9;
    static float nl = (float) 23;
    static float nh = (float) 24.9;
    static float ol = (float) 25;
    static float oh = (float) 29.9;
    static float o1l = (float) 30;
    static float o1h = (float) 34.9;
    static float o2l = (float) 35;
    static float o2h = (float) 39.9;
    static float o3 = (float) 40;

    /*public static void Initialize(int age, boolean isMale){
        if(age<25)
            as=0;
        if((age>=25) && (age<=34))
            as=1;
        else if((age>=35) && (age<=44))
            as=2;
        else if((age>=45) && (age<=54))
            as=3;
        else if((age>=55) && (age<=64))
            as=4;
        else if(age>=65)
            as=5;

        if(isMale)
            bi=1;
        else
            bi = 0;

        u = (float) 18.9 + as + bi;
        ml = (float) 19 + as + bi;
        mh = (float) 22.9 + as + bi;
        nl = (float) 23 + as + bi;
        nh = (float) 24.9 + as + bi;
        ol = (float) 25 + as + bi;
        oh = (float) 29.9 + as + bi;
        o1l = (float) 30 + as + bi;
        o1h = (float) 34.9 + as + bi;
        o2l = (float) 35 + as + bi;
        o2h = (float) 39.9 + as + bi;
        o3 = (float) 40 + as + bi;
    }*/

    public static float bmiCalculate(int height, int weight) {
        float l = height / 100;
        l += (height % 100) * 0.01;
        if (height > 0 && weight > 0)
                return fix((weight / (l * l)), 1);
        return 0;
    }

    public static int bodyStatus(float bmi){
        if (bmi <= u)
            return 0;
        else if ((bmi >= ml) && (bmi <= mh))
            return 1;
        else if ((bmi >= nl) && (bmi <= nh))
            return 2;
        else if ((bmi >= ol) && (bmi <= oh))
            return 3;
        else if ((bmi >= o1l) && (bmi <= o1h))
            return 4;
        else if ((bmi >= o2l) && (bmi <= o2h))
            return 5;
        else if (bmi >= o3)
            return 6;

        return -1;
    }

    public static String getBest(int height)
    {
        float h = Float.valueOf(height);
        return String.valueOf(fix((h * h / 10000) * 24,1));
    }

    public static String gotoStd(int weight, float BW)
    {
        String result = String.valueOf(fix(BW - weight,1));
        if (Float.valueOf(result)>0)
            result = "+" + result;

        return result;
    }

    public static int getMinimum(int height, int BW) {
        int i = BW;
        boolean e = false;
        int s;

        while (!e) {
            i--;
            s = bodyStatus(bmiCalculate(height, i));
            if (s!=2)
                e = true;
        }

        return i+1;
    }

    public static int getMaximum(int height, int BW) {
        int i = BW;
        boolean e = false;
        int s;

        while (!e) {
            i++;
            s = bodyStatus(bmiCalculate(height, i));
            if (s!=2)
                e = true;
        }

        return  i-1;
    }

    public static float fix(float value, int point){
        String pp = "%." + point + "f";
        String fixed = String.format(Locale.US, pp, value);
        if (fixed.substring(0, 1) == ".")
            fixed = "0" + fixed;

        return Float.valueOf(fixed);
    }

}
