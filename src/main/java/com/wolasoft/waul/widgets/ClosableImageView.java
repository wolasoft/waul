package com.wolasoft.waul.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.wolasoft.waul.R;
import com.wolasoft.waul.utils.DimensionUtils;

public class ClosableImageView extends FrameLayout {

    private ImageView imageView;
    private ImageButton closeButton;

    public ClosableImageView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ClosableImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClosableImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClosableImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.closable_image_view, this, true);
        closeButton = view.findViewById(R.id.button);
        imageView = view.findViewById(R.id.image);
        // setCloseButtonSize(closeButton);
    }

    private void setCloseButtonSize(View view) {
        view.setLayoutParams(
                new FrameLayout.LayoutParams(
                        DimensionUtils.dpToPx(getContext(),10),
                        DimensionUtils.dpToPx(getContext(),10)));
    }
    public void setImage(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    public void setImage(Uri uri) {
        imageView.setImageURI(uri);
    }

    public View getCloseButton() {
        return closeButton;
    }
}
