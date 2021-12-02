package com.synergics.stb.iptv.leanback.models.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.synergics.stb.iptv.leanback.models.TVItems;

import java.util.List;

@Dao
public interface TVItemDao {
    @Query("SELECT * FROM tv_items")
    List<TVItems> getAll();

    @Query("SELECT * FROM tv_items WHERE categoryId=:categoryId")
    List<TVItems> getByCategory(int categoryId);

    @Query("SELECT * FROM tv_items WHERE id=:id")
    TVItems getById(int id);

    @Insert
    void insert(TVItems... items);

    @Insert
    void insert(List<TVItems> items);

    @Update
    void update(TVItems... items);

    @Delete
    void delete(TVItems... items);
}
