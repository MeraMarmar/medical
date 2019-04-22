package com.example.mdecinenotofication.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import java.util.ArrayList;
import java.util.List;
@Dao
public interface mediceDAO {
    @Query("SELECT * FROM Medecine")
    List<Medecine> getAll();

    @Insert
    void insert(Medecine medecine);

    @Delete
    void delete(Medecine medecine);

    @Update
    void update(Medecine medecine);
}
