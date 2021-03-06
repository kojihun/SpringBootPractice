package com.example.demo.controller;

import javax.validation.Valid;

import com.example.demo.dto.User2;
import com.example.demo.dto.Usere;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class는 REST API를 처리하는 Controller
@RequestMapping("/api") // RequestMapping은 URI를 지정해주는 Annotation
public class ApiController {

    @PostMapping("/user")
    public Object user(@Valid @RequestBody Usere user, BindingResult bindingResult) {
        // validation에 대한 결과가 bindingResult에 담기게 된다.
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                // 에러가 발생한 필드와 message에 적힌 내용을 화면에 출력한다.
                System.out.println(field.getField());
                System.out.println(message);

                sb.append("field: " + field.getField());
                sb.append("message: " + message);
            });

            // 응답 body안에 메세지를 전송해준다.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(user);
        return user;
    }

    @GetMapping("") // required는 주소뒤에 파라미터가 없을 경우 null을 보낸다.
    public User2 get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User2 user = new User2();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;
        return user;
    }

    @PostMapping("")
    public User2 post(@RequestBody User2 user) {
        System.out.println(user);
        return user;
    }
}
