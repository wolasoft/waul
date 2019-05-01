package com.wolasoft.waul.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.wolasoft.waul.R;

import androidx.appcompat.widget.AppCompatEditText;

public class CustomEditText extends AppCompatEditText {
    private boolean error = false;
    private static final int[] ERROR_STATE = new int[] {R.attr.state_error};

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] state  = super.onCreateDrawableState(extraSpace + 1);

        if (error) {
            mergeDrawableStates(state, ERROR_STATE);
        }

        return state;
    }

    public void setError(boolean error) {
        this.error = error;
        refreshDrawableState();
    }
}
