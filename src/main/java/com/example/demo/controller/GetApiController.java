package com.example.demo.controller;

import java.util.Map;

import com.example.demo.dto.UserRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // GET > localhost:9090/api/get/hello
    @GetMapping(path = "/hello")
    public String hello() {
        return "get Hello";
    }

    // GET > localhost:9090/api/get/hi
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "get hi";
    }

    // PathVariable받는 방법
    // GET > localhost:9090/api/get/path-variable/{name}
    @GetMapping(path = "/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String name) {
        System.out.println("PathVariable:" + name);
        return name;
    }

    // QueryParameter
    // GET > localhost:9090/api/get/query-param?user=steve
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    // 명시적으로 지정할 수 있다.
    @GetMapping(path = "/query-param02")
    public String queryParam02(@RequestParam String name, @RequestParam String email) {
        return name + " " + email;
    }

    // DTO를 사용하여 쿼리 파라미터를 받는 방법 => 변수와 이름을 매칭한다.
    @GetMapping(path = "/query-param03")
    public String queryParam03(UserRequest userRequest) {
        return userRequest.toString();
    }
}
