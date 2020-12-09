package com.example.springbootvarnish.space;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@Slf4j
public class GreetingFromMarsRestController {

    @GetMapping("/greeting")
    public String greeting(){
        log.info("Greeting from MARS... {}",LocalDateTime.now());
        return "Hello hello from Mars";
    }

    @GetMapping("/greetingnotcached")
    public ResponseEntity<String> notcached(){
        log.info("Response not cached... {}",LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control","no-cache");
        ResponseEntity<String> response = new ResponseEntity<>("Test 123",
                headers, HttpStatus.OK);
        return response;
    }

    @GetMapping("/greetingmaxage")
    public ResponseEntity<String> maxcache(){
        log.info("bla bla bla Max age... {}",LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control","max-age=10");
        ResponseEntity<String> response = new ResponseEntity<>("Max age... set.",
                headers, HttpStatus.OK);
        return response;
    }
}
