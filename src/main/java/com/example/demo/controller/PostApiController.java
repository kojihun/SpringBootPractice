package com.example.demo.controller;

import com.example.demo.dto.PostRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping(path = "/post")
    public void post(@RequestBody PostRequestDto postRequestDto) {
        System.out.println(postRequestDto.toString());
    }
}
