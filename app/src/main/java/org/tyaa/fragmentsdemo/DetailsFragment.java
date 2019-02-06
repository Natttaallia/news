package org.tyaa.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.tyaa.fragmentsdemo.globals.DataCollections;
import org.tyaa.fragmentsdemo.model.NewsItem;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class DetailsFragment extends Fragment {

    //private String mItemTextString;
    private Integer mNewsId;
    private TextView mDetailsTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*mItemTextString =
                (String)getActivity()
                        .getIntent()
                        .getSerializableExtra(ItemsListFragment.EXTRA_ITEM_TEXT);*/
        /*mItemTextString =
                (String)getArguments().getSerializable(ItemsListFragment.EXTRA_ITEM_TEXT);*/
        mNewsId =
                (Integer) getArguments().getSerializable(ItemsListFragment.EXTRA_ITEM_TEXT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Optional<NewsItem> newsItemOptional =
            DataCollections.newsItems.stream().filter(new Predicate<NewsItem>() {
                @Override
                public boolean test(NewsItem newsItem) {
                    return newsItem.getId() == mNewsId;
                }
            }).findFirst();

        NewsItem newsItem = newsItemOptional.get();

        View view =
            inflater.inflate(R.layout.fragment_details, container, false);
        mDetailsTextView = (TextView)view.findViewById(R.id.detailsTextView);
        mDetailsTextView.setText(newsItem.getTitle());
        return view;
    }

    //public static DetailsFragment newInstance(String _itemTextString){
    public static DetailsFragment newInstance(Integer _newsId){
        Bundle args = new Bundle();
        //args.putSerializable(ItemsListFragment.EXTRA_ITEM_TEXT, _itemTextString);
        args.putSerializable(ItemsListFragment.EXTRA_ITEM_TEXT, _newsId);
        DetailsFragment secondFragment = new DetailsFragment();
        secondFragment.setArguments(args);
        return secondFragment;
    }
}
