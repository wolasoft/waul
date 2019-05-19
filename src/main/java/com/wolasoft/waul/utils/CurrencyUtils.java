package com.wolasoft.waul.utils;

import android.content.Context;

import com.wolasoft.waul.R;

import java.text.DecimalFormat;

public class CurrencyUtils {
    public static String formatToCfa(Context context, int amount) {
        final String currency = context.getString(R.string.currency_cfa);
        DecimalFormat formatter = new  DecimalFormat("###,###.###");
        String formattedAmount = formatter.format(amount) + " " +currency;

        return formattedAmount;
    }
}
