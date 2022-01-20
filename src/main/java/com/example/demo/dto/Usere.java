package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usere {
    private String name;
    private int age;

    // 이메일에 양식이 맞지 않을 경우 에러를 리턴
    @Email
    private String email;

    // 정규식에 일치하지 않을 경우 에러를 리턴
    @Pattern(regexp = "^\\d{2,3}", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxxx-xxxx")
    private String phoneNumber;
}
