package com.synergics.stb.iptv.leanback.models.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.synergics.stb.iptv.leanback.models.TVCategories;

import java.util.List;
@Dao
public interface TVCategoriesDao {
    @Query("SELECT * FROM tv_categories")
    List<TVCategories> all();

    @Query("SELECT * FROM tv_categories WHERE nama=:nama")
    TVCategories getByNama(String nama);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(TVCategories categories);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insert(TVCategories... categories);

    @Update
    void update(TVCategories... categories);

    @Delete
    void delete(TVCategories... categories);
}
