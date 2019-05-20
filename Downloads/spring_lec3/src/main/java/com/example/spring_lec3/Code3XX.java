package com.example.spring_lec3;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Code3XX {
	@RequestMapping("/c301")
	public String c301(HttpServletResponse response) {
	    response.setStatus(301);
	    response.setHeader("Location", "http://www.naver.com");
	    
	    // 일반적으로 redirect 응답에는 바디를 포함하지 않음 (그러나 금지는 아님)
	    // https://stackoverflow.com/questions/8059662/http-302-redirect-is-a-message-body-needed
	    return "Moved Permanently";
	}
	
	// 리다이렉트를 수행하는 다양한 방법들	​
	// sendRedirect 메소드 호출하여 리다이렉트
	@RequestMapping("/c302")
	public void c302(HttpServletResponse response) throws IOException {
	    response.sendRedirect("http://www.naver.com");
	}
	
	// RedirectView 객체를 이용
	/*
	@RequestMapping("/c302")
	public RedirectView c302() {
	    return new RedirectView("http://www.naver.com");
	}
	*/
	
	// ModelAndView의 뷰 이름 앞에 redirect:를 붙이고 뒤에 URL를 써줌
	/*
	@RequestMapping("/c302")
	public ModelAndView c302() {
	    return new ModelAndView("redirect:http://www.naver.com");
	}
	*/

}
