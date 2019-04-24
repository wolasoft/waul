package com.wolasoft.waul.databindings;

import android.widget.TextView;

import com.wolasoft.waul.R;

import java.text.DecimalFormat;

import androidx.databinding.BindingAdapter;

public class PriceBindingAdapter {

    @BindingAdapter({"app:amount"})
    public static void format(TextView view, int amount) {
        final String currency = view.getContext().getString(R.string.currency_cfa);
        DecimalFormat formatter = new  DecimalFormat("###,###.###");
        String formattedAmount = formatter.format(amount) + " " +currency;
        view.setText(formattedAmount);
    }
}
