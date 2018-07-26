package com.techelevator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (!password.equals("1234")) {
			request.setAttribute("error", "Failed to Login");
			return "login";
		}
		
		request.setAttribute("username", username);
		
		return "afterLogin";
	}
}
