package com.alephreach.prodrivetime_android.utils;

import java.text.NumberFormat;

public class CurrencyFormat {

    public static String getCurrencyFormat(String s) {

        double number = Double.valueOf(s);

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(number);
    }
}
