package com.example.pernance.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.pernance.db.converter.DateConverter;
import com.example.pernance.db.converter.FlowTypeConverter;
import com.example.pernance.db.types.FlowType;

import java.util.Date;

@Entity(tableName = "RecordTable",
    foreignKeys = @ForeignKey(
            entity = User.class,
            parentColumns = "Id",
            childColumns = "UserId",
            onDelete = ForeignKey.CASCADE
    ))
public class Record {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    @ColumnInfo(name = "UserId")
    private int userId;

    @ColumnInfo(name = "FlowType")
    @TypeConverters(FlowTypeConverter.class)
    private FlowType flowType;

    @ColumnInfo(name = "Nominal")
    private float nominal;

    @ColumnInfo(name = "Categories")
    private String categories;

    @ColumnInfo(name = "Timestamp")
    @TypeConverters(DateConverter.class)
    private Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public FlowType getFlowType() {
        return flowType;
    }

    public void setFlowType(FlowType flowType) {
        this.flowType = flowType;
    }

    public float getNominal() {
        return nominal;
    }

    public void setNominal(float nominal) {
        this.nominal = nominal;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
