package com.example.demo.controller;

import com.example.demo.dto.PutReqeustDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {

    // PUT > localhost:9090/api/put
    @PutMapping(path = "/put/{userId}")
    public void put(@RequestBody PutReqeustDto putReqeustDto, @PathVariable(name = "userId") Long Id) {
        System.out.println(putReqeustDto.toString() + Id);
    }
}
