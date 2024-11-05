package com.jp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jp.jwt.JwtService;

@Service
public class LoginService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	public String genereateToken(LoginRequest request) {
		Authentication authenticate = authenticationManager.authenticate(
				 new UsernamePasswordAuthenticationToken(request.getEmail(), 
						 request.getPassword()));
		if(!authenticate.isAuthenticated()) {
			throw new UsernameNotFoundException("Invalid username:"+request.getEmail());
		}
		
		UserDetails userDetails = (UserDetails)authenticate.getPrincipal();
		return jwtService.generateJwtToken(userDetails);
	}

}
