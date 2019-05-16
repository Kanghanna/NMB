package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping("/hello") //localhost:1234/hello
	public String hello() { //위 이름과 일치시킬 필요 x
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "<marquee style='font-size: 24px; color: red;'>Hello</marquee>";
	}
	
	/*
	@RequestMapping(value="/ab/cd", method=RequestMethod.GET)
	public String abcd() {
		return "abcd";
	}
	*/
	@GetMapping("/ab/cd")
	public String abcd() {
		return "abcd";
	}

	@RequestMapping(value="/ab/cd", method=RequestMethod.POST)
	public String abcdq2() {
		return "abcd2";
	}

	
}
