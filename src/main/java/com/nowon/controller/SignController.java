package com.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nowon.domain.dto.MemberDTO;
import com.nowon.service.MemberService;

@Controller
public class SignController {

	@Autowired
	MemberService memsevice;
	
	@GetMapping ("/signup03")
	public String singup03() {
		return "layout/signup03";
	}
	
	@PostMapping ("/signup03")
	public String signup03P(@ModelAttribute MemberDTO memberDTO) {
		System.out.println(memberDTO.getEmail());
		memsevice.save(memberDTO);
		return "redirect:/";
	}
	
	@GetMapping ("/signin")
	public String signin() {
		return "layout/login";
	}
}
