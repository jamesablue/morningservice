package com.morningservice.morningservice.controllers;

import com.morningservice.morningservice.services.MetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class MetroController {
    @Autowired
    MetroService metroService;

    @PostMapping
    public ResponseEntity<Void> addLog() {
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping("home")
    public ResponseEntity<Void> home() {
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping("printkey")
    public String printkey() {
        return metroService.getApiKey();
    }

    @RequestMapping("getStationInfo/{stationCode}")
    public String getStationInfo(@PathVariable String stationCode) {
        return metroService.getStationInfo(stationCode);
    }
}
