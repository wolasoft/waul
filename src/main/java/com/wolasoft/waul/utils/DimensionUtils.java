package com.wolasoft.waul.utils;

import android.content.Context;

public class DimensionUtils {

    public static int dpToPx(Context context, int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
}
