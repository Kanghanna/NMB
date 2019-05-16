package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //
public class MyController3 {

	@RequestMapping("/request_param2")
	public String requestParamTest2(
			@RequestParam(value = "name") String name, //필수적인 값(못 받으면 에러)
			@RequestParam(value = "age", required = false) Integer age) { //필수적인 값 아님, 
		    //기본 값은 String이므로 Integer도 받을 수 있지만 String을 받아도 에러 안남
		return name + "," + age;
	}
	
	@RequestMapping("/request_param3")
	// Map<String, String> : 파라미터 값이 많을 때 한꺼번에 모두 받을 Map을 사용
	public String requestParamTest3(@RequestParam Map<String, String> params) {    
		String result = "";    
		for(String key : params.keySet()) {        
			result += (key + "/" + params.get(key) + " ");    
		} 
		return result; 
	}
	
	// @PathVariable을 이용하여 URL Path에 포함된 변수 가져오기 가능
	@GetMapping("/path_variable/{abc}/{def}") 
	// 조건 1. 변수 이름과 Mapping에 들어가는 이름이 같아야 함 (abc) 
	// 조건 2. @PathVariable 어노테이션에 전달된 값이 같아야 함 (def) 
	public String pathVariableTest(@PathVariable Integer abc, @PathVariable("def") String asdf) {     
		return abc + "," + asdf; 
	}
	
	
	//요청과 응답에 대한 low 레벨 접근 방법
	// 리턴 타입이 void임을 주목
	@RequestMapping("/servlet_object") 
	public void servletObjectTest(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {    
		// request 객체를 이용하여 요청에 대한 정보 확인 가능    
		// 파라미터 정보 접근    
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {        
		 String name = e.nextElement();        
		System.out.println("param : " + name + " : " + request.getParameter(name));    
		}

	 
	 	 // 헤더 정보 접근    
	 	 e = request.getHeaderNames();    
		 while(e.hasMoreElements()) {        
			 String name = e.nextElement();        
			 System.out.println("header : " + name + " : " + request.getHeader(name));    
			 }
		 // 바디 정보 접근   
		 System.out.println("Body\n");    
			 BufferedReader reader = request.getReader();    
			 String s = null;    
			 while((s = reader.readLine()) != null) {        
				 System.out.println(s);    
				 }        
			 // response 객체를 이용하여 응답에 대한 정보 추가/변경 가능   
			 // 응답 코드와 응답 정보에 대한 형식을 헤더 정보에 추가    
			 response.setStatus(200); //정상적인 결과
			 response.setContentType("application/json");    
			 response.setCharacterEncoding("utf-8");   
			 response.setContentLength(5); //pdf - lec3 (body에 넣은 컨텐츠의 크기도 정할 수 있음)
			 
			 // 넘어온 쿼리 스트링 정보를 json 형태로 출력하여 바디에 붙이기    
			 PrintWriter writer = response.getWriter();    
			 writer.append("{");    
			 e = request.getParameterNames();    
			 String sep = "";    
			 while(e.hasMoreElements()) {        
				 String name = e.nextElement();        
				 writer.append(sep + "\"" + name + "\":");        
				 writer.append("\"" + request.getParameter(name) + "\"");        
				 sep = ",";    
			}    
			 writer.append("}");    
			 }

}
