package com.clockworkjava.kursspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/knights").hasAnyRole("USER", "ADMIN")
                .antMatchers("/knight").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/knights");
    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("{noop}user1").roles("USER")
                .and()
                .withUser("user2").password("{noop}user2").roles("ADMIN");
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username,password,enabled FROM PLAYER_INFORMATION WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username,role FROM ROLE WHERE username = ?");
    }
}
