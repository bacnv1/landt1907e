package com.t3h.filternews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabLayout;
import com.t3h.filternews.adapter.NewsPagerAdapter;
import com.t3h.filternews.api.ApiBuilder;
import com.t3h.filternews.dao.AppDatabase;
import com.t3h.filternews.fragments.FavoriteFragment;
import com.t3h.filternews.fragments.NewsFragment;
import com.t3h.filternews.fragments.SavedFragment;
import com.t3h.filternews.models.News;
import com.t3h.filternews.models.NewsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, Callback<NewsResponse> {

    private ViewPager pager;
    private TabLayout tab;
    private NewsPagerAdapter adapter;

    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSave = new SavedFragment();
    private FavoriteFragment fmFavorite = new FavoriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        adapter = new NewsPagerAdapter(
                getSupportFragmentManager(),
                fmNews, fmSave, fmFavorite
        );
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        // TODO
        List<News> data = AppDatabase.getInstance(this)
                .getNewsDao().getNews();
        fmNews.setData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView search = (SearchView)
                menu.findItem(R.id.menu_search).getActionView();
        search.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        pager.setCurrentItem(0);
        ApiBuilder.getInstance().searchNews(
                query,
                "f70e06a71e524dfa86dbfcf7ca38e62f",
                "vi"
        ).enqueue(this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        NewsResponse newsResponse = response.body();
        ArrayList<News> data = newsResponse.getArticles();
        fmNews.setData(data);
        News[] news = new News[data.size()];
        data.toArray(news);
        AppDatabase.getInstance(this).getNewsDao().insert(news);
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {

    }
}
