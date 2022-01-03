package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutReqeustDto {
    private String name;
    private int age;
    private List<CarDto> carList;
}
