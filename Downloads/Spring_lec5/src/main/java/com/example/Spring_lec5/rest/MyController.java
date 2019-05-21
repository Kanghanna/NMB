package com.example.Spring_lec5.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller("myRestController")
@RequestMapping("/rest")
public class MyController {
	@GetMapping("/error_arithmetic") //에러 생성
    @ResponseBody
    public String doArithmetic() {
        return (10 / 0) + "";
    }
}

