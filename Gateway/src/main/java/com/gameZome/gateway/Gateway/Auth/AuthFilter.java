package com.gameZome.gateway.Gateway.Auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthFilter extends OncePerRequestFilter{

	@Autowired
	JWTUtility jwtUtility;
	@Autowired
	UserDetailsService userDetailService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Filter Called-------"+request.getRequestURL() );
		
		final String jwtToken = request.getHeader("Authorization");
		
		if(jwtToken!=null && jwtToken.startsWith("Bearer "))
		{
			final String token = jwtToken.substring(7);
			
			if(jwtUtility.isvalidUserToken(token) || jwtUtility.isvalidMicroserviceToken(token))
			{
				UserDetails details = User.builder().username("Authenticated").password("Authenticated").build();
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			
			
		}
		filterChain.doFilter(request, response);
		
		
	}

}
