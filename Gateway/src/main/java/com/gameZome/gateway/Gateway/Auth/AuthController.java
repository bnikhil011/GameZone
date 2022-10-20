package com.gameZome.gateway.Gateway.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamezone.models.gamezone_models.AuthRequest;
import com.gamezone.models.gamezone_models.AuthResponse;


@RestController
public class AuthController {
	@Autowired
	AuthenticationManager authManager;

	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	JWTUtility jwtUtility;
	
	@PostMapping("/authenticate")
	ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest request)
	{
		final String token ;
		System.out.println("Reached controller");
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			if(request.getUsername().equals("ADMIN"))
				token = jwtUtility.getUserToken(request.getUsername()); 
			else
				token = jwtUtility.getServiceToken(request.getUsername());
			return new ResponseEntity<AuthResponse>(new AuthResponse(token),HttpStatus.ACCEPTED);
		}
		catch(BadCredentialsException ex )
		{
			ex.printStackTrace();
		}
		
		return new ResponseEntity<AuthResponse>(new AuthResponse(null, "Wrong Credentials"),HttpStatus.BAD_REQUEST);
		
		
		
	}
	

}
