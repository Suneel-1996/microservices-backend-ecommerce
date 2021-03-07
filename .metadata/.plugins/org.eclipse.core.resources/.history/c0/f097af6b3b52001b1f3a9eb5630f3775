package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
//	@Autowired
//	public MessageSource msg;
	@GetMapping("/")
	@ResponseBody
	public String sendMessage() {
		
		return "Hello World";
		//return msg.getMessage("welcome.message",null);
	}

}
