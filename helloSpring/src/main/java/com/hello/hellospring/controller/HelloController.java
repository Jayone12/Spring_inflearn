package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
