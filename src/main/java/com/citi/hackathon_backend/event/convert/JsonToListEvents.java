package com.citi.hackathon_backend.event.convert;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.citi.hackathon_backend.event.entity.Event;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class JsonToListEvents implements DynamoDBTypeConverter<String, Object> {
    private Gson gson = new Gson();

    @Override
    public String convert(Object o) {
        return gson.toJson(o);
    }

    @Override
    public Object unconvert(String s) {
        Event[] events=gson.fromJson(s, Event[].class);
        return List.of(events);
    }
}
