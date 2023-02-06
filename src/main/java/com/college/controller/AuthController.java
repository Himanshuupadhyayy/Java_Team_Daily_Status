package com.college.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.config.JWTHelperUtil;
import com.college.*;
import com.college.entity.JWTRequest;
import com.college.entity.*;
import com.college.entity.User;
import com.college.service.UserDetailsServiceSecurity;
import com.college.service.UserService;

@RestController
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private JWTHelperUtil jwtHelperUtil;
	@Autowired
	private UserDetailsServiceSecurity detailsServiceImPL;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("user not found ");
		}
		UserDetails userdetails=this.detailsServiceImPL.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtHelperUtil.generateToken(userdetails);
		return ResponseEntity.ok(new JWTResponse(token));
	}
	 
	
 	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch (DisabledException e) {
			throw new Exception("User Disabled "+e.getMessage());
		}
		catch(BadCredentialsException e) {
			throw new Exception("invalid credentials "+e.getMessage());
		}
	}
	
	//return the details of current login user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User) this.detailsServiceImPL.loadUserByUsername(principal.getName()));
	}
	
	
	
}