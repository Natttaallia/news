package org.tyaa.fragmentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import static org.tyaa.fragmentsdemo.DetailsFragment.DETAILS_RESULT_CODE;
import static org.tyaa.fragmentsdemo.DetailsFragment.EXTRA_DETAILS_RESPONSE;

public class DetailsActivity extends SingleFragmentActivity {

    //private String mItemTextString;
    private Integer mNewsId;
    protected OnBackPressedListener onBackPressedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*mItemTextString =
                (String)getIntent()
                        .getSerializableExtra(ItemsListFragment.EXTRA_ITEM_TEXT);*/
        mNewsId =
                (Integer)getIntent()
                        .getSerializableExtra(ItemsListFragment.EXTRA_ITEM_TEXT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Fragment createFragment() {
        //return new DetailsFragment();
        //return DetailsFragment.newInstance(mItemTextString);
        return DetailsFragment.newInstance(mNewsId);
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    public void onBackPressed() {

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentMainContainer, createFragment())
                .commit();*/

        if (onBackPressedListener != null){
            onBackPressedListener.doBack();
        }
        super.onBackPressed();
    }
}
