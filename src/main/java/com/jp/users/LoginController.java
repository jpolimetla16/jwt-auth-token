package com.jp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/authenticate")
	public String login(@RequestBody LoginRequest request) {
		return loginService.genereateToken(request);
	}
	
}
