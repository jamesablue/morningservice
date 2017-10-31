package com.morningservice.morningservice.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RestController
public class Controllers {
    @RequestMapping("/home")
    public String home() {
        return "homepage";
    }

    @RequestMapping("/localdatetime")
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    @RequestMapping("/name/{name}/{repetitions}")
    public String name(@PathVariable String name, @PathVariable int repetitions) {
        return IntStream.rangeClosed(1, repetitions)
                .mapToObj(i -> "Hello, " + name)
                .collect(Collectors.joining("\n"));
    }

    @PostMapping(path = "/post")
    //public String post(@RequestBody String name, @RequestBody int reps) {
    public String post(@RequestBody Params params) {
        return IntStream.rangeClosed(1, params.getReps())
                .mapToObj(i -> "Hello, " + params.getName())
                .collect(Collectors.joining("\n"));
    }

    static class Params {
        private String name;
        private int reps;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }
    }
}
