package com.wolasoft.waul.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ImageUtils {
    public static File createTempFileFromBitmap(Context context, Bitmap bitmap) {
        File file = new File(context.getCacheDir(),
                String.valueOf(Calendar.getInstance().getTimeInMillis()));
        try {
            if (file.createNewFile()) {
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0 , byteStream);
                byte[] bitmapData = byteStream.toByteArray();

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(bitmapData);
                fos.flush();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

    public static Target download(Context context, final String imageDir, final String imageName) {
        ContextWrapper contextWrapper = new ContextWrapper(context);
        final File directory = contextWrapper.getDir(imageDir, Context.MODE_PRIVATE);
        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final File imageFile = new File(directory, imageName);
                        try {
                            FileOutputStream fos = new FileOutputStream(imageFile);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 0, fos);
                            fos.flush();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Log.i("image", "image saved to >>>" + imageFile.getAbsolutePath());
                    }
                }).start();
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) { }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) { }
        };
    }

    public static File loadImageFromDisk(Context context, String imageDir, String imageName) {
        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getDir(imageDir, Context.MODE_PRIVATE);
        File imageFile = null;

        try {
            imageFile = new File(directory, imageName);
            Log.i("image", "image loaded from disk");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageFile;
    }

    public static void deleteFromDisk(Context context, String imageDir, String imageName) {
        File myImageFile = loadImageFromDisk(context, imageDir, imageName);
        if (myImageFile.delete()) Log.d("image", "image deleted from disk!");

    }
}
