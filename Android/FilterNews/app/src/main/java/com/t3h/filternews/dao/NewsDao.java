package com.t3h.filternews.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t3h.filternews.models.News;

import java.util.List;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM News")
    List<News> getNews();

    @Insert
    void insert(News ... news);

    @Update
    void update(News ... news);

    @Delete
    void delete(News ... news);
}