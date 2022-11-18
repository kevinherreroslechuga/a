package org.generation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/clientes/**").permitAll()
				//.antMatchers(HttpMethod.POST, "/api/clientes").hasRole("USER")
				//.antMatchers(HttpMethod.PUT, "/api/clientes").hasRole("USER") //.roles("USER","ADMIN")
				//.antMatchers(HttpMethod.DELETE, "/api/clientes/**").hasRole("ADMIN")				
			.anyRequest().authenticated() ;//.permitAll()
			
								
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("eli") //username
			.password("{noop}patrona") //password
			.roles("ADMIN")
			.and()
			.withUser("karla")
			.password("{noop}textranamos")
			.roles("USER");
	
	}
	
}
