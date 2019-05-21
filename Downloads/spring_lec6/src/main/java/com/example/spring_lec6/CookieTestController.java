package com.example.spring_lec6;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CookieTestController {

	@GetMapping("/add_cookie_data_page")
	public String addCookieDataPage() {   
		return "add_cookie_data_page"; 
	}
	
	@PostMapping("/add_cookie_data")
	@ResponseBody 
	public String addCookieData(@RequestParam Map<String, String> params, HttpServletResponse response) {
		for(String key : params.keySet()) {
			Cookie c = new Cookie(key, params.get(key).toString());
			c.setMaxAge(60); // 쿠키의 만료 시간 지정, 단위는 초 (여기서는 60초)        
			c.setHttpOnly(true); //자바스크립트에서 document.cookie 를 이용해 cookie정보를 사용하는 것을 막는 메소드(보안을 위함)
			// c.setSecure(true); // 'https'에서만 적용 가능한 setHttpOnly()메소드   
			// c.setPath("/page");        
			response.addCookie(c); 
		}
		return "Success";
	}
	
	
	@GetMapping("/get_cookie_data") 
	@ResponseBody 
	public String getCookieData(        
			@CookieValue(value="data1", defaultValue="Hello") String data1,         
			@CookieValue(value="asdf", required=false) String asdf) {
		return data1 + " " + asdf; 
	}

}
