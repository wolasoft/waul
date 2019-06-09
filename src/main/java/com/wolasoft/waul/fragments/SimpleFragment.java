package com.wolasoft.waul.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

    protected int getInteger(int resId) {
        return getContext().getResources().getInteger(resId);
    }

    protected boolean getBoolean(int resId) {
        return getContext().getResources().getBoolean(resId);
    }

    protected int getOrientation() {
        return getContext().getResources().getConfiguration().orientation;
    }

    protected void setTitle(int id) {
        getActivity().setTitle(id);
    }

    protected void setTitle(String title) {
        getActivity().setTitle(title);
    }

    protected void invalidateOptionsMenu() {
        getActivity().invalidateOptionsMenu();
    }

    protected void replaceToolbar(Toolbar toolbar) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
    }
}
