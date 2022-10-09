package com.gameZome.dataHandler.datahandler.Auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class GatewayUserDetailService implements UserDetailsService{

	// will not be used ever as filter will block this flow
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("ADMIN"))
			return User.builder().username(username).password("ADMIN").build();
		else if(username.equals("MS"))
			return User.builder().username(username).password("MS").build();
		else
			throw new UsernameNotFoundException("USER NAME NOT FOUND");
			
		
	}

}
