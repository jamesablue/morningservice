package com.morningservice.morningservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@ComponentScan(basePackages={"com.morningservice.morningservice.controllers"})
@SpringBootApplication
//@ComponentScan("com.morningservice.morningservice.controllers")
@RestController
public class MorningserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorningserviceApplication.class, args);
	}

//	@RequestMapping("/home")
//	public String home() {
//		return "homepage";
//	}
//
//	@RequestMapping("/localdatetime")
//	public LocalDateTime localDateTime() {
//		return LocalDateTime.now();
//	}
//
//	@RequestMapping("/name/{name}/{repetitions}")
//	public String name(@PathVariable String name, @PathVariable int repetitions) {
//		return IntStream.rangeClosed(1, repetitions)
//				.mapToObj(i -> "Hello, " + name)
//				.collect(Collectors.joining("\n"));
//	}
}
