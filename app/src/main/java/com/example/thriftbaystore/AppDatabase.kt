package com.example.thriftbaystore

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Products::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase(){
    abstract fun storeDao():StoreDao

    companion object {
        var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase?{
            if(INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "products.db")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}