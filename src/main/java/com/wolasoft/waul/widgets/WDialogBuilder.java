package com.wolasoft.waul.widgets;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class WDialogBuilder {

    public static AlertDialog.Builder create(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (title != null && !title.equals("")) {
            builder.setTitle(title);
        }

        if (message != null && !message.equals("")) {
            builder.setMessage(message);
        }

        return builder;
    }
}
