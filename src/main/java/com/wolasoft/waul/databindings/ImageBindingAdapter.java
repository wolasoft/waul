package com.wolasoft.waul.databindings;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wolasoft.waul.R;

import androidx.databinding.BindingAdapter;

public class ImageBindingAdapter {

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (imageUrl != null && !imageUrl.equals("")) {
            Picasso.get()
                    .load(imageUrl)
                    .error(R.drawable.ic_photo_size_select_actual_black_24dp)
                    .placeholder(R.drawable.ic_photo_size_select_actual_black_24dp)
                    .into(view);
        } else {
            view.setImageDrawable(
                    view.getContext().getResources().getDrawable(R.drawable.ic_photo_size_select_actual_black_24dp));
        }
    }
}