package com.wolasoft.waul.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

    protected Context context = getContext();

    public void setTitle(int id) {
        getActivity().setTitle(id);
    }

    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    public void startActivity(Intent intent) {
        getActivity().startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle options) {
        getActivity().startActivity(intent, options);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        getActivity().startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        getActivity().startActivityForResult(intent, requestCode, options);
    }

    public void invalidateOptionsMenu() {
        getActivity().invalidateOptionsMenu();
    }
}
