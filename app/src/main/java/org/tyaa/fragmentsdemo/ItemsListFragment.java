package org.tyaa.fragmentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
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
import java.util.function.Consumer;

public class ItemsListFragment extends ListFragment {

    public static final String EXTRA_ITEM_TEXT = "com.tyaa.fragmentsdemo.item_text";
    public static final Integer DETAILS_REQUEST_CODE = 0;

    //private ArrayList<String> mItems;
    private ArrayList<NewsItem> mItems;
    private NewsAdapter mItemsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*mItems = new ArrayList<String>();
        mItems.add("One");
        mItems.add("Two");
        mItems.add("Three");*/
        //mItems = new ArrayList<NewsItem>();
        mItems = DataCollections.newsItems;
        if (mItems.isEmpty()){
            mItems.add(new NewsItem(1, "news1", "Lorem ipsum dolor sit amet 1"));
            mItems.add(new NewsItem(2, "news2", "Lorem ipsum dolor sit amet 2"));
            mItems.add(new NewsItem(3, "news3", "Lorem ipsum dolor sit amet 3"));
        }

        //ItemsAdapter itemsAdapter = new ItemsAdapter(mItems);
        mItemsAdapter = new NewsAdapter(mItems);
        setListAdapter(mItemsAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        /*Toast toast = Toast.makeText(
                getActivity(), mItems.get(position), Toast.LENGTH_SHORT
        );
        toast.show();*/

        /*Intent detailsActivityIntent =
                new Intent(getActivity(), DetailsActivity.class);
        String selectedText = mItems.get(position);
        detailsActivityIntent.putExtra(EXTRA_ITEM_TEXT, selectedText);
        startActivity(detailsActivityIntent);*/

        Intent detailsActivityIntent =
                new Intent(getActivity(), DetailsActivity.class);
        Integer selectedNewsId = mItems.get(position).getId();
        detailsActivityIntent.putExtra(EXTRA_ITEM_TEXT, selectedNewsId);
        //startActivity(detailsActivityIntent);
        startActivityForResult(detailsActivityIntent, DETAILS_REQUEST_CODE);
    }

    /*private class ItemsAdapter extends ArrayAdapter<String> {

        public ItemsAdapter(ArrayList<String> items) {
            super(getActivity(), android.R.layout.simple_list_item_1, items);
        }
    }*/

    private class NewsAdapter extends ArrayAdapter<NewsItem> {

        public NewsAdapter(ArrayList<NewsItem> newsItem) {
            super(getActivity(), 0, newsItem);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.fragment_items_list_item, null);
            }
            NewsItem newsItem = getItem(position);
            TextView titleTextView =
                    convertView.findViewById(R.id.listItemTitleTextView);
            TextView contentTextView =
                    convertView.findViewById(R.id.listItemContentTextView);
            titleTextView.setText(newsItem.getTitle());
            contentTextView.setText(newsItem.getContent());

            //return super.getView(position, convertView, parent);
            return convertView;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DETAILS_REQUEST_CODE){
            if (data != null){
                Toast.makeText(
                        getActivity()
                        , data.getStringExtra(DetailsFragment.EXTRA_DETAILS_RESPONSE)
                        , Toast.LENGTH_SHORT
                ).show();
                /*mItems.forEach(new Consumer<NewsItem>() {
                    @Override
                    public void accept(NewsItem newsItem) {
                        Log.d("item", newsItem.getTitle());
                    }
                });*/
                mItemsAdapter.notifyDataSetInvalidated();
            } else {
                Toast.makeText(
                        getActivity()
                        , "No result"
                        , Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}
