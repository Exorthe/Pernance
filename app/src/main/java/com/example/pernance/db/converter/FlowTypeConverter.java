package com.example.pernance.db.converter;

import androidx.room.TypeConverter;

import com.example.pernance.db.types.FlowType;

public class FlowTypeConverter {
    @TypeConverter
    public static FlowType toFlowType(String flowType){
        return FlowType.valueOf(flowType);
    }

    @TypeConverter
    public static String fromFlowType(FlowType flowType){
        return flowType.name();
    }
}
