package com.kineCenter.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
		
	
	@Autowired
	private DataSource dataSource;
		@Override
		//configure main
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			//auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
			PasswordEncoder passwordEncoder = passwordEncoder();
			//System.out.println("Passwors Encoded BCRYPT :******************** ");
			//System.out.println(passwordEncoder.encode("123admin"));

			auth.jdbcAuthentication()
			 .dataSource(dataSource)
			 .usersByUsernameQuery("select username , password , enabled from user where username =?")
			 .authoritiesByUsernameQuery(
			 "SELECT username, role " +
			 "FROM user " +
			 "WHERE username = ?")
			 .passwordEncoder(passwordEncoder)
			 .rolePrefix("ROLE_");
			
		} //fin configure
			

		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder;
		}



	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		 //http.authorizeRequests().anyRequest().authenticated();
		 http.formLogin();
		 http.logout().logoutSuccessUrl("/");
	 } 
}
	
