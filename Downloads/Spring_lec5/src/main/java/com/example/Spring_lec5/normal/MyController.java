package com.example.Spring_lec5.normal;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("myNormalController")
@RequestMapping("/normal")
public class MyController {
	@GetMapping("/error_arithmetic") //에러 생성
    @ResponseBody
    public String doArithmetic() {
        return (10 / 0) + "";
    }
}


