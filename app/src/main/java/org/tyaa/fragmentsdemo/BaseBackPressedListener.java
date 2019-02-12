package org.tyaa.fragmentsdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class BaseBackPressedListener implements OnBackPressedListener {

    private final SingleFragmentActivity activity;

    public BaseBackPressedListener(SingleFragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void doBack() {
        activity.getSupportFragmentManager()
                .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
