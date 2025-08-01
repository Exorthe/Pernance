package com.example.pernance.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.pernance.db.PernanceDatabase;
import com.example.pernance.db.dao.RecordDao;
import com.example.pernance.db.entities.Record;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecordRepository {
    private final RecordDao recordDao;
    private final LiveData<List<Record>> allRecords;
    private final ExecutorService executorService;

    RecordRepository(Application application){
        PernanceDatabase db = PernanceDatabase.getInstance(application);

        recordDao = db.recordDao();
        allRecords = recordDao.getAllRecords();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<Record>> getAllRecords(){
        return allRecords;
    }

    public void addRecord (Record record){
        executorService.execute(() -> recordDao.addRecord(record));
    }

    public void updateRecord(Record record){
        executorService.execute(() -> recordDao.updateRecord(record));
    }

    public void deleteRecord(Record record){
        executorService.execute(() -> recordDao.deleteRecord(record));
    }
}
