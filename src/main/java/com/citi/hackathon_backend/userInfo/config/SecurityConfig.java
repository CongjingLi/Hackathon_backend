//package com.citi.hackathon_backend.userInfo.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeHttpRequests().antMatchers("/api/user/login","/api/user/register")
//                .permitAll().anyRequest().authenticated()
//                .and().formLogin().loginPage("api/user/login")
//                .and().logout().logoutSuccessUrl("api/user/login");
//    }
//}