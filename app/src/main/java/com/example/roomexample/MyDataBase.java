package com.example.roomexample;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    public abstract ProductDAO productDAO();

    private static volatile MyDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDataBase.class, "my_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}