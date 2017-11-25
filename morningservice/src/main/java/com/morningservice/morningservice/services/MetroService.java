package com.morningservice.morningservice.services;

import com.morningservice.morningservice.utilities.TrainTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Configuration
public class MetroService {

    @Autowired
    private TrainTimes trainTimes;

    @Value("${api.key}")
    private String apiKey;

    private String predictionUrl = "https://api.wmata.com/StationPrediction.svc/json/GetPrediction/";

    public String getApiKey() {
        return apiKey;
    }

    public String getStationInfo(String stationCode) {
        String responseJson = getStationInfoResponseJson(stationCode);

        //return trainTimes.getTrainTimes(responseJson);
        return trainTimes.getTrainTimes(responseJson);
        //return restTemplate.getForObject(predictionUrl + stationCode, String.class);
    }

    public String getStationInfoRaw(String stationCode) {
        String responseJson = getStationInfoResponseJson(stationCode);

        return trainTimes.getTrainTimesRaw(responseJson);
    }

    public String getStationInfoResponseJson(String stationCode) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("api_key", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        String responseJson = restTemplate.exchange(predictionUrl + stationCode, HttpMethod.GET, entity, String.class).getBody();

        return responseJson;
    }


}
