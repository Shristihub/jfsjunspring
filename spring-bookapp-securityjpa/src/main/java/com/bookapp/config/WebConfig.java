package com.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.bookapp.service.ApiUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {
	// 2 beans - authentication and authorization
	// authentication bean

	@Bean
	UserDetailsService userDetailsService() {
		return new ApiUserServiceImpl();
	}

	// password encoder bean
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authentication provider bean
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}
	// authorization bean

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests((auth) -> {
			auth.requestMatchers("/user-api/v1/api-users/**").permitAll();
//			.anyRequest().authenticated();
		})
				.httpBasic(Customizer.withDefaults())
				.authenticationProvider(authenticationProvider()).build();
	}

}
