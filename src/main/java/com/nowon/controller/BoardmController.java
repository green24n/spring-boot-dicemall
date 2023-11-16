package com.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardmController {

	@GetMapping ("/signup01")
	public String signup01() {
		return "layout/signup01";
	}
	@GetMapping ("/signup02")
	public String signup02() {
		return "layout/signup02";
	}
	/*
	@GetMapping ("/signup03")
	public String signup03() {
		return "layout/signup03";
	}
	*/
	@GetMapping ("/help")
	public String help() {
		return "front/help/help";
	}
}
