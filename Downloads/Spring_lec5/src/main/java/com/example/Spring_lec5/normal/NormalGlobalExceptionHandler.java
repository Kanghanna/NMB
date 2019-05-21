package com.example.Spring_lec5.normal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//com.example.spring_lec4.example 패키지와 그 하위 패키지의 컨트롤러 에러를 처리
@ControllerAdvice("com.example.Spring_lec5.normal")
public class NormalGlobalExceptionHandler {
	    
	    @ExceptionHandler(value=Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public String globalErrorHandler(Model m, HttpServletRequest req, Exception ex) throws Exception {
	        
	        m.addAttribute("cause", ex.getMessage());
	        
	        return "/myerror/error_global";
	    }
}
