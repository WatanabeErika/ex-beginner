package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;
	
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/result")
	public String result(int item1,int item2,int item3) {
		int total=item1+item2+item3;
		application.setAttribute("total", total);
		
		int tax=(int)(total*0.1);
		int total2=total+tax;
		application.setAttribute("total2", total2);
		
		return "exam03-result";
	}
}
