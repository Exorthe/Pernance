package com.example.pernance.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pernance.db.entities.Record;

import java.util.List;

@Dao
public interface RecordDao {
    @Query("SELECT * FROM RecordTable WHERE UserId = :userId")
    LiveData<List<Record>> getAllRecordByUser(int userId);

    @Insert
    void addRecord(Record record);

    @Update
    void updateRecord(Record record);

    @Delete
    void deleteRecord(Record record);
}
