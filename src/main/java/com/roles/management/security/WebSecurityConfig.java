///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.roles.management.security;
//
///**
// *
// * @author BlackAngel
// */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(bCryptPasswordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        //We use the JWTAuthorization filter that we created
////        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        http.authorizeRequests().antMatchers("/register", "/login", "/roles/addroles","/folders/**").permitAll();
//
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/").hasAuthority("consultation");
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/shops/update").hasAuthority("update");
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/shops/delete").hasAuthority("delete");
//        //We don't need the session offered by spring because we will work with JWT
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        //all APIs require authentication 
//        http.authorizeRequests().anyRequest().authenticated();
//
//        //We use the JWTAuthentication filter that we created
//       // http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
//
//    }
//
//}
