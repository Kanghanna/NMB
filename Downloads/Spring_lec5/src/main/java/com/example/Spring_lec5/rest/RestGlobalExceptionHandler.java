package com.example.Spring_lec5.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//com.example.spring_lec4.example 패키지와 그 하위 패키지의 컨트롤러 에러를 처리
@ControllerAdvice("com.example.Spring_lec5.rest")
public class RestGlobalExceptionHandler {
	@ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody Map<String, Object> globalErrorHandler() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cause", "something");
        return map;
    }
}
