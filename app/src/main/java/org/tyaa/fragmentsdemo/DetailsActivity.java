package org.tyaa.fragmentsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class DetailsActivity extends SingleFragmentActivity {

    //private String mItemTextString;
    private Integer mNewsId;

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
}
