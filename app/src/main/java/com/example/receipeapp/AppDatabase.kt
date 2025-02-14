package com.example.receipeapp

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Recipe::class], exportSchema = false, version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract  fun getDao():Dao

}