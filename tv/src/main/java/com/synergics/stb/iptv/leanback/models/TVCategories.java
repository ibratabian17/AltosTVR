package com.synergics.stb.iptv.leanback.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.synergics.stb.iptv.leanback.BaseApplication;
import com.synergics.stb.iptv.leanback.models.db.MyDatabase;

import java.util.List;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "tv_categories")
public class TVCategories {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nama;

    @Ignore
    private List<TVItems> tv;

    public TVCategories() { }

    @Ignore
    public TVCategories(String nama) {
        this.nama = nama;
    }

    @Ignore
    public TVCategories(List<TVItems> tv) {
        this.tv = tv;
    }

    @Ignore
    public TVCategories(String nama, List<TVItems> tv) {
        this.nama = nama;
        this.tv = tv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TVItems> getTv() {
        if (tv != null)
            return tv;

        // Todo load from database
        return BaseApplication.database.tvItemDao().getByCategory(id);
    }

    public void setTv(List<TVItems> tv) {
        this.tv = tv;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
