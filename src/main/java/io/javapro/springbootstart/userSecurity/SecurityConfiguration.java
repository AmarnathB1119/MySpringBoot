package io.javapro.springbootstart.userSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.javapro.springbootstart.userController.JwtRequestFilter;
import io.javapro.springbootstart.userService.UserDetailsServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}
	
	
//  Bypass the other Api's by declaring inside the Authentication Matchers
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests()
//		.antMatchers("/authenticate", "/hello", "/topic").permitAll().anyRequest().authenticated();
//	}
	
//  Bypass the other Api's by Automatic Default operation

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/login").permitAll().anyRequest().authenticated().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
//		http.requestMatchers()
//		.antMatchers("/login").and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().authorizeHttpRequests()
//		.antMatchers("/topic").permitAll()
//		.anyRequest().authenticated();
		
		
//		 http.authorizeRequests()
//		 .antMatchers("login").permitAll().and()
//		 .requestMatchers().antMatchers("/topic").anyRequest();
//		
		
		
	
		http.csrf().disable();
		
        //.antMatchers(HttpMethod.OPTIONS).permitAll()
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
    	web.ignoring().antMatchers("/topic");

	}


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}
