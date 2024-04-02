package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 이는 컨트롤러로 지정한다.
@Controller
public class HelloController {
	
	// {rootPath}/hello를 사용자가 요청시 아래와 같은 내용을 전달한다.
	@GetMapping("hello")
	public String hello(Model model) {
		// model의 경우 사용자에게 페이지를 응답할 때 페이지에 해당 내용을 전달한다.
		model.addAttribute("data", "hello!!");
		// 마지막으로 viewResolver가 templates에 있는 파일명을 찾아 렌더링해준다.(확장자는 생략)
		// `resources:templates/` + {ViewName} + `.html`
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	// HTTP의 BODY에 문자 내용을 직접 반환
	// viewResolver 대신에 httpMessageConverter가 동작한다.
	// 기본 문자처리: StringHttpMessageConverter
	// 기본 객체처리: MappingJackson2HttpMessageConverter
	// byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}
	
	static class Hello{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}
