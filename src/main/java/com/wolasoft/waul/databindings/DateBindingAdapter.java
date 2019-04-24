package com.wolasoft.waul.databindings;

import android.widget.TextView;

import com.wolasoft.waul.utils.DateUtilities;

import java.util.Date;

import androidx.databinding.BindingAdapter;

public class DateBindingAdapter {

    @BindingAdapter({"app:date"})
    public static void format(TextView view, Date date) {
        view.setText(DateUtilities.format(date, view.getContext()));
    }
}