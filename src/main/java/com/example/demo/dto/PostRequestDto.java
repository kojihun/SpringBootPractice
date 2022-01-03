package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostRequestDto {
    private String account;
    private String email;

    // JsonProperty를 사용하게 될 경우 카멜케이스나 스네이크케이스의 경우에 모두 커버할 수 있다.
    @JsonProperty("phone_num")
    private String phoneNum;
}
