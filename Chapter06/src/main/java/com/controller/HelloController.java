package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//핸들러맵핑 연결
@Controller
public class HelloController {
	
//url에서 jsp가 실행되지 않게 하기위해 /WEB-INF에 jsp 파일을 작성
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello(){ // 사용자가 만든 콜백메소드
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "hello Spring MVC!");
		
		//JSP의 파일명 -> /view/hello.jsp (prefix, suffix때문에 알아서 찾아감)
		//mav.setViewName("hello");
		mav.setViewName("/view/hello");
		
		return mav;
	}
	
	/*
	 스프링에서 리턴타입이 String이면 단순 문자열이 아니라 JSP파일명으로 인식함 -> /WEB-INF/welcome.jsp를 찾음
	 단순 문자열로 처리하고 싶으면 @ResponseBody를 붙인다
	*/
	@RequestMapping(value="/hello2.do", method=RequestMethod.GET, produces="text/html; charset=UTF-8") //request, get, first가능
	//@GetMapping(value="/hello2.do")
	@ResponseBody
	public String hello2() {
		//return "welcome";
		return "안녕하슈";
	}
	
}
