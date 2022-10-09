package com.gameZome.gateway.Gateway.Auth;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.gameZome.gateway.Gateway.MicroserviceAndUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JWTUtility {
	
	
	private static final String screat_key ="base_24_encr";

	private JwtBuilder generateToken(String  userName)
	{
		Map<String ,Object> claims = new HashMap<>();
		
		return Jwts.builder().setClaims(claims).setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+(1000*1000)))
				.signWith(SignatureAlgorithm.HS512, screat_key);
				
	}
	public String getUserToken(String userName)
	{
		return generateToken(userName).compact();
	}
	public String getServiceToken(String serviceName)
	{
		return generateToken(serviceName).setSubject("MiccroserviceCall").compact();
	}
	
	private String getSubjectFromTokenAfterCheck(String token )
	{
		Claims claim  = Jwts.parser().setSigningKey(screat_key).parseClaimsJws(token).getBody();
		
		if(claim.getExpiration().before(new Date()))
			return "notfound";
		
		String subject = claim.getSubject();
		
		return subject;
		
	}
	
	public boolean isvalidMicroserviceToken(String token)
	{
		String subject = getSubjectFromTokenAfterCheck(token);
	
		return subject.equals("MS") ;
		
	}
	
	public boolean isvalidUserToken(String token )
	{
		String subject = getSubjectFromTokenAfterCheck(token);
		
		return subject.equals("ADMIN");
		
	}
	
	
	
	
}
