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
                    .error(R.drawable.no_image)
                    .placeholder(R.drawable.no_image)
                    .into(view);
        } else {
            view.setImageDrawable(
                    view.getContext().getResources().getDrawable(R.drawable.no_image));
        }
    }
}