package com.TA_2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		 .authorizeRequests()
		 .antMatchers("/").permitAll()
		 .antMatchers("/css/**").permitAll()
		 .antMatchers("/js/**").permitAll()
		 .antMatchers("/ruang/viewall").hasRole("PEGAWAI")
		 .antMatchers("/ruang/view/**").hasRole("MAHASISWA")		
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()
		 .loginPage("/login")
		 .permitAll()
		 .and()
		 .logout()
		 .permitAll();
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select username,password,enabled from user_account where username=?")
		.authoritiesByUsernameQuery("select username, role from user_account where username=?");
	}
}
