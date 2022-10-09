package com.gameZome.dataHandler.datahandler.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigClass {
	
	@Bean
	PasswordEncoder getEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	@Bean
	RestTemplate getrestTemplate()
	{
		return new RestTemplate();
	}


}
