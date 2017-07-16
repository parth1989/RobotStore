package com.robotstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().authorizeRequests()
    	.antMatchers("/", "/home").permitAll()
    	.antMatchers("/userScreen").hasAnyRole("ADMIN","USER")
    	.antMatchers("/adminScreen").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
    .formLogin()
        .loginPage("/login")
        .permitAll().successHandler(customSuccessHandler)
        .and()
    .logout()
        .permitAll();
        
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
        .withUser("user1").password("password1").roles("ADMIN")
        .and()
        .withUser("user2").password("password2").roles("USER");
    }
}
