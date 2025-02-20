package com.Security.SecurityLearning.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Hello ji");
    }
}
