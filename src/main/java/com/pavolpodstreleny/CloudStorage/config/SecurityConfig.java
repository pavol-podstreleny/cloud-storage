package com.pavolpodstreleny.CloudStorage.config;

import com.pavolpodstreleny.CloudStorage.service.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    final AuthenticationService authenticationService;

    public SecurityConfig(final AuthenticationService authenticationService) {this.authenticationService = authenticationService;}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/signup", "/css/**", "/js/**", "/img/**").permitAll().anyRequest()
                .authenticated();
        http.formLogin().loginPage("/login").permitAll().and().formLogin().defaultSuccessUrl("/files", true);
        http.logout().permitAll();
    }

}
