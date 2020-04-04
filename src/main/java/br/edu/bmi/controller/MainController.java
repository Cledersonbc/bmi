package br.edu.bmi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	private boolean logged = false;

	@RequestMapping("login")
	public String loginPage() {
		return "index";
	}

	// Fake login
	@PostMapping("login")
	public String authenticate() {
		logged = true;
		return "redirect:/home";
	}

	@RequestMapping("home")
	public String homePage() {
		if (logged) {
			return "home";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping("logout")
	public String logoutPage() {
		logged = false;
		return "logout";
	}

}
