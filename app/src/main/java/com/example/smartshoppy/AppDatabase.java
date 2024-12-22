package com.example.smartshoppy;

import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract ProductDao ProductDao();
}
