package com.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowListController {

	@GetMapping ("/showlist01")
	public String showList01() {
		return "front/showlist/showlist01";
	}
}
