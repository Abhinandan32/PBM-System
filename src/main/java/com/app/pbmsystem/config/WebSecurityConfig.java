package com.app.pbmsystem.config;

import com.app.pbmsystem.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailService userDetailService;

    @Autowired
    public WebSecurityConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/user/login", "/logout", "/login")
                .permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .csrf().disable();

    }
}
