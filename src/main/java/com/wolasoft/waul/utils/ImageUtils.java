package com.wolasoft.waul.utils;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class ImageUtils {
    public static File createTempFileFromBitmap(Context context, Bitmap bitmap) {
        File file = new File(context.getCacheDir(),
                String.valueOf(Calendar.getInstance().getTimeInMillis()));
        try {
            file.createNewFile();
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 , byteStream);
            byte[] bitmapData = byteStream.toByteArray();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapData);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }
}
