package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User2 {

    @NotEmpty
    @Size(min = 1, max = 10)
    private String name;

    @Min(1)
    @NotNull
    private Integer age;
}
