package com.example.Spring_lec5.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No Odd Number Allowed.") //reason과 메소드 안의 super를 같은 값으로 인식 안함(실제 출력 값은 reason)
class NoOddNumberException extends Exception { //홀수를 입력하면 예외처리 실행
    public NoOddNumberException(int num) {
        super(num + "은 홀수입니다.");
    }
}


@RestController
public class MyController {
/*
	@GetMapping("/no_odd")
	public String noOdd(@RequestParam("num") Integer num) throws NoOddNumberException {
		if(num %2 == 0) {
			return "good";
		} else {
			throw new NoOddNumberException(num);
		}
	}
*/	
	@GetMapping("/error_no_odd_number2")
@ResponseBody
public String noOddNumber2(@RequestParam("num") Integer num) throws NoOddNumberException {
    if((num % 2) != 0) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "홀수 사용은 허용되지 않음. (입력값 : " + num + ")");
    }
    return num + "";
}

}


