package com.wolasoft.waul.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {
    protected FragmentManager manager = getSupportFragmentManager();

    protected void replaceFragment(int containerView, Fragment fragment, String tag,
                                   boolean addToBackStack) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerView, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
