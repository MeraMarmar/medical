package com.example.mdecinenotofication.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Medecine.class}, version = 1)
public abstract class appdatabase extends RoomDatabase {
    public abstract mediceDAO mediceDAO();
}