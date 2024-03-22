package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {

	
/*	@GetMapping(value="/sungJuk/input.do")
	//@RequestMapping(value="/input.do", method=RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";
	}*/
	//@PostMapping(value="/sungJuk/input.do")
	@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";
	}
	
//	@GetMapping(value="/result.do")
//	public String result() {
//
//		return "/view/result";
//	}

	/*
	 * @GetMapping(value="/result.do") public ModelAndView result(//@RequestParam
	 * Map<String,String> map, ModelMap modelmap)
	 * 
	 * @RequestParam(required = false, defaultValue="0") int x,
	 * 
	 * @RequestParam(required = false, defaultValue="0") int y) {
	 * 
	 * 
	 * // modelMap.put("x", map.gqt("x")); // modelMap.put("y", map.gqt("y")); //
	 * return "/view/result";
	 * 
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.addObject("x", x);
	 * mav.addObject("y", y); //JSP의 파일명 -> /view/hello.jsp (prefix, suffix때문에 알아서
	 * 찾아감) //mav.setViewName("hello"); mav.setViewName("/view/result");
	 * 
	 * return mav;
	 * 
	 * }
	 */
	
	@PostMapping(value="/sungJuk/result.do")
	   public String result(@RequestBody SumDTO sumDTO){
		String name = sumDTO.getName();
		int kor = sumDTO.getKor();
		int eng = sumDTO.getEng();
		int math = sumDTO.getMath();
		int tot = kor + eng + math;
		double avg = tot/3.;
	    return "/sungJuk/result";
	   }
	
	
}
