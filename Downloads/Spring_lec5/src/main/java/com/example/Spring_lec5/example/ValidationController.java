package com.example.Spring_lec5.example;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

	class Member implements Serializable {
	    @NotBlank
	    @Size(min=2, max=10)
	    private String name;
	    
	    @Positive
	    @Min(1)
	    @Max(130)
	    private int age;
	    @NotNull
	    @NotBlank
	    @Email
	    private String email;
	    
	    @Pattern(regexp="[a-zA-Z1-9]{4,8}", message="비밀번호 양식이 틀렸습니다.")
	    private String password;
	    
	    private String gender;
	    @AssertTrue(message="성별은 여성이거나 남성이어야 합니다.")
	    public boolean isValidGender(){
	        if(gender == null) return true;
	        
	        return gender.equals("남성") || gender.equals("여성"); 
	    }
		public String getName() {
			return name;
			
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
	    
	    
}
	
	public class ValidationController {
		
		 @GetMapping("/member_register")
		    public String getMemberJoinPage(Member m) {
		        return "member_register";
		    }
		
		@PostMapping("/member")
	    public String addMember(@Valid Member member, BindingResult result, Model model) {
			//@Valid를 하면 매개변수로 넘어오기 전에 유효성 검사하라는 뜻
			//Valid한 결과를 BindingResult에 받음
			
	        // BindingResult의 hasErrors 메소드 사용하여 에러 여부 확인
	        if(result.hasErrors()) { //hasErrors()는 에러가 하나라도 있으면 true 반환
	            // 다시 폼이 있는 템플릿을 돌려줌 (오류 값이 포함된 Form-backing bean이 다시 전달됨)
	            return "member_register";
	        }
	        
	        // 회원 가입 로직 처리 (ex: 데이터베이스에 데이터 삽입)
	        
	        return "member_congratulation";
	    }
		
		
		// BindingResult 객체 사용 방법 살펴보기
	    @GetMapping("/check_member")
	    @ResponseBody
	    public String checkMemberInfo(@Valid Member m, BindingResult result) {
	        if (result.hasErrors()) {
	            // 총 발생한 에러 개수
	            System.out.println("error count : " + result.getErrorCount());
	            
	            List<FieldError> list = result.getFieldErrors();
	            for(FieldError e : list) {
	                System.out.println(e.getField()); // 발생한 멤버 변수(필드)의 이름
	                System.out.println(e.getObjectName()); // 에러 발생한 데이터 클래스의 이름
	                System.out.println(e.getRejectedValue()); // 반려된 입력값
	                System.out.println(e.getDefaultMessage()); // 반려된 사유
	            }
	        }
	        
	        return "Success";
	    }
	}
