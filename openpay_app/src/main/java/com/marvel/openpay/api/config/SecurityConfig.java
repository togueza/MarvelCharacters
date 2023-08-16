package com.marvel.openpay.api.config;

import com.marvel.openpay.api.model.UserTable;
import com.marvel.openpay.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            UserTable user = userRepository.findByUsername(username);//userRepository.findOne(username);
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            if (user != null) {
                return new org.springframework.security.core.userdetails.User(user.getUsername(), encoder.encode(user.getPassword()),
                true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            } else {
                throw new UsernameNotFoundException("Could not find the user '" + username + "'");
            }
        });
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
    }*/
}
