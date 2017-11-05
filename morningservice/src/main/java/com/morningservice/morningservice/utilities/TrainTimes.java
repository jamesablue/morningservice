package com.morningservice.morningservice.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TrainTimes {

    public String getTrainTimes(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ResponseTrainTimes responseTrainTimes = objectMapper.readValue(json, ResponseTrainTimes.class);

            return responseTrainTimes.toReport();
        } catch (Exception e) {
            return "Something went wrong: " + e.toString();
        }
    }

    public static class ResponseTrainTimes {
        @JsonProperty("Trains")
        private List<Train> trains;

        public String toReport() {
            StringBuilder stringBuilder = new StringBuilder();

            for (Train train : this.trains) {
                stringBuilder.append(train.toReport());
                stringBuilder.append("<br>");
            }

            return stringBuilder.toString();
        }

        public List<Train> getTrains() {
            return trains;
        }

        public void setTrains(List<Train> trains) {
            this.trains = trains;
        }
    }

    public static class Train {
        @JsonProperty("Car")
        private String car;

        @JsonProperty("Destination")
        private String destination;

        @JsonProperty("DestinationCode")
        private String destinationCode;

        @JsonProperty("DestinationName")
        private String destinationName;

        @JsonProperty("Group")
        private String group;

        @JsonProperty("Line")
        private String line;

        @JsonProperty("LocationCode")
        private String locationCode;

        @JsonProperty("LocationName")
        private String locationName;

        @JsonProperty("Min")
        private String min;

        public String toReport() {
            return String.format("Car: %s; Destination: %s; Min: %s", this.getCar(), this.getDestinationName(), this.getMin());
        }

        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getDestinationCode() {
            return destinationCode;
        }

        public void setDestinationCode(String destinationCode) {
            this.destinationCode = destinationCode;
        }

        public String getDestinationName() {
            return destinationName;
        }

        public void setDestinationName(String destinationName) {
            this.destinationName = destinationName;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String getLocationCode() {
            return locationCode;
        }

        public void setLocationCode(String locationCode) {
            this.locationCode = locationCode;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }
    }
}
