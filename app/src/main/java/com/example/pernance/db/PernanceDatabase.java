package com.example.pernance.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pernance.db.dao.RecordDao;
import com.example.pernance.db.entities.Record;

@Database(entities = {Record.class}, version = 1)
public abstract class PernanceDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "pernance-db";

    private static volatile PernanceDatabase INSTANCE;

    public abstract RecordDao recordDao();

    public static PernanceDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (PernanceDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PernanceDatabase.class, DATABASE_NAME).build();
                }
            }
        }

        return INSTANCE;
    }
}
