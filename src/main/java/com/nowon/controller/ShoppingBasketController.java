package com.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingBasketController {

	@GetMapping ("/shoppingbasket")
	public String shoppingbasket() {
		return "/shoppingbasket/shoppingbasket";
	}
}
