package com.twg.springboot.webapprestapi.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Bean
	public UserDetailsManager congifDataSource(DataSource datasource)
    {
    	UserDetailsManager UDM=new JdbcUserDetailsManager(datasource);
    	
    	return UDM;
    }
    
    @Bean
    public SecurityFilterChain autorizeHttpRequests(HttpSecurity http) throws Exception
    {
	    	http
	    	 .authorizeHttpRequests(
	    			 
	    			 (authorize) -> {

                         authorize
                           .requestMatchers(HttpMethod.DELETE, "/entries/**").hasAuthority("ROLE_ADMIN")
                           .requestMatchers(HttpMethod.PUT, "/entries/**").hasAuthority("ROLE_MANAGER")

                           .anyRequest().authenticated();

                       } 
	    			 
	    		)
	    	 
	    	 .httpBasic(withDefaults())
	    	 .csrf(csrf -> csrf.disable())
	    	 ;
    	 
    	 return http.build();
    }
}
