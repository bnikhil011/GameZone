package com.gameZome.gateway.Gateway.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDeatilService;
	
	@Autowired
	AuthFilter authFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDeatilService);
		/*
		 * For JDBC config directily from heare
		 
			auth
			.jdbcAuthentication()
			.dataSource(datasource)
			.usersByUsernameQuery("select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
		*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Security Config Called"); 
		 http.csrf().disable()
		 .authorizeRequests().antMatchers("/authenticate").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 .and()
		 .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
		 ;
	}
	

	@Bean
	public AuthenticationManager getManager() throws Exception
	{
		return super.authenticationManagerBean();
	}

	


}
