package com.example.receipeapp

import androidx.room.Query
import androidx.room.Dao
@Dao
interface Dao {
    @Query("SELECT * FROM recipe")
    fun getAll():ArrayList<Recipe>

}