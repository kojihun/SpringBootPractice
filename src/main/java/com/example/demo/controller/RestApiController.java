package com.example.demo.controller;

import com.example.demo.annotation.Timer;
import com.example.demo.dto.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " " + name;
    }

    @PostMapping(path = "/post/rest")
    public User post(@RequestBody User user) {
        return user;
    }

    @Timer
    @DeleteMapping(path = "/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(1000 * 2);
    }
}
