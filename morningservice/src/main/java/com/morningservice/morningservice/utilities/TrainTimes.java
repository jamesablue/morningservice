package com.morningservice.morningservice.utilities;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TrainTimes {

    public String getTrainTimes(String json) {
        GsonJsonParser gsonJsonParser = new GsonJsonParser();

        Map<String,Object> map = gsonJsonParser.parseMap(json);

        return map.toString();
    }
}
