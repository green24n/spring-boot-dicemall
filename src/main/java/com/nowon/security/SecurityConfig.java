package com.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(13);
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf((csrf)->csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
				.antMatchers("/css/**","/img/**","/js/**").permitAll()
				.antMatchers("/","/signup03","/signin").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(formlogin->formlogin
					.loginPage("/signin")
					.loginProcessingUrl("/signin")
					.usernameParameter("email")
					.passwordParameter("pass"));

		return http.build();
	}

}
