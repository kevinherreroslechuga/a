package org.generation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/customer/**").permitAll()
				//.antMatchers(HttpMethod.POST, "/api/customer").hasRole("USER")
				//.antMatchers(HttpMethod.PUT, "/api/customer").hasRole("USER") //.roles("USER","ADMIN")
				//.antMatchers(HttpMethod.DELETE, "/api/customer/**").hasRole("ADMIN")				
			.anyRequest().authenticated() //.permitAll()
			.and()
			.addFilterBefore(new LoginFilter("/login", authenticationManager()),
					UsernamePasswordAuthenticationFilter.class)//Actuará este filtro sobre /login y esto nos da el token JWT
			.addFilterBefore(new JwtFilter(),UsernamePasswordAuthenticationFilter.class) //Revisará si el token es correcto
			.csrf().disable();							
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("eli") //username
			.password("{noop}lapatrona") //password
			.roles("ADMIN")
			.and()
			.withUser("karla")
			.password("{noop}textranamos")
			.roles("USER");
	
	}
	
}
