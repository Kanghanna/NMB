package com.example.demo;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//(3) 조건
class Student implements Serializable {
	private Integer id;
	private String name;
	private String email;
	private boolean genius;
	
	// (2) 조건 : 외부에서 접근 가능한(public) 기본 생성자(no-arg constructor) 제공
	public Student() {     
		super();  
	}
	
	 public Student(Integer id, String name, String email, boolean genius) {
		 super();
		 this.id = id;        
		 this.name = name;        
		 this.email = email;        
		 this.genius = genius;    
	}

	public Integer getId() {
		//System.out.println("getId"); //private인 Id에 접근하는 것이 아님, getter setter에 모두 접근
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGenius() {
		return genius;
	}

	public void setGenius(boolean genius) {
		this.genius = genius;
	}
	 
}




@Controller
public class MyController2 {
	
		@GetMapping("/hello3")
		public String hello() {
			return "hello"; // hello.html 뷰(템플릿)을 사용
		}
		
		@GetMapping("/hello4")
		public String practice() {
			return "practice"; // practice.html 뷰(템플릿)을 사용
		}
		
		@GetMapping("model") public String model(Model m) { // 파라미터에 Model 타입 값 받음(/ 생략 가능)
			//addAttribute(String, Object);
			m.addAttribute("title", "Hello World 1234"); // 뷰(템플릿) 내부에 필요한 내용 채우기
			m.addAttribute("content", "Content 1234");
			return "with_model"; // 역시 템플릿 이름 리턴
		}
		
		@GetMapping("model_and_view") public ModelAndView modelAndView() { // 반환 타입이 ModelAndView
			ModelAndView m = new ModelAndView("with_model");// 뷰(템플릿) 이름 지정
			// addObject(String, Object)
			m.addObject("title", "Hello World 1234");
			m.addObject("content", "Content 1234");
			return m;
		}
		
		@GetMapping("student") public String student(Model m) {    
			m.addAttribute("title", "Student page");
			// 메소드 시그니쳐 addAttribute(String, Object) 임을 주목, Object 이므로 어떤 클래스도 전 달 가능   
			m.addAttribute("student", new Student(1, "철수", "chulsoo@naver.com", false));        
			return "student";       
		}

		@GetMapping("student2") public ModelAndView student2(Student s) {
			// 파라미터의 Student 타입을 주목    
			ModelAndView m = new ModelAndView("student");    
			m.addObject("title", "Student page");    
			m.addObject("student", s);        
			return m; 
		}

		
	}

