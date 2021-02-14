package com.example.appnexttestapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface AppDao {

    @Query("SELECT * FROM AppModel ORDER BY rating DESC")
    fun getAll(): LiveData<List<AppModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(apps: Collection<AppModel>)

    @Query("DELETE FROM AppModel")
    fun deleteAll()
}