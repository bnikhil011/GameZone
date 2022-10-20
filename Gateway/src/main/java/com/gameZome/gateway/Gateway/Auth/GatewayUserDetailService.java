package com.gameZome.gateway.Gateway.Auth;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GatewayUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("ADMIN"))
			return new User(username,"ADMIN",new ArrayList<GrantedAuthority>());
		else if(username.equals("MS"))
			return User.builder().username(username).password("MS").build();
		else
			throw new UsernameNotFoundException("USER NAME NOT FOUND");
			
		
	}

}
