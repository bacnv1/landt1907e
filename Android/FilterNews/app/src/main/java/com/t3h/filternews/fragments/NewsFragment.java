package com.t3h.filternews.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.filternews.R;
import com.t3h.filternews.adapter.NewsAdapter;
import com.t3h.filternews.base.BaseFragment;
import com.t3h.filternews.models.News;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment {

    private ArrayList<News> data = new ArrayList<>();
    private RecyclerView lvNews;
    private NewsAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvNews = findViewById(R.id.lv_news);
        adapter = new NewsAdapter(getLayoutInflater());
        adapter.setData(data);
        lvNews.setAdapter(adapter);
    }

    public void setData(List<News> data) {
        this.data.clear();
        this.data.addAll(data);
        if (adapter != null) {
            adapter.setData(this.data);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    public String getTitle() {
        return "News";
    }
}
