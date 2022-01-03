package com.example.demo;

import com.example.demo.dto.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("Hello~");

		// Text JSON -> Object
		// Object -> Text JSON

		// controller req json(text) -> object
		// response object -> json(text)

		// object -> text
		// object mapper가 get method를 활용한다.
		var objectMapper = new ObjectMapper();
		var user = new UserRequest("steve", "google.com");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		// text -> object
		// object mapper는 default생성자를 필요로 한다.
		var objectUser = objectMapper.readValue(text, UserRequest.class);
		System.out.println(objectUser);
	}
}
