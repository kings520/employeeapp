package com.employeeapp.security;

import com.employeeapp.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "com.employeeapp.repository")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
   private CustomUserDetailsService userDetailsService;

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        //httpSecurity.csrf().disable();
        httpSecurity

                .authorizeRequests()
                .antMatchers("/resources/**", "/static/**","/css/**","/js/**","/images/**","/fontawesome-5.9.0/**").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("Admin")
                .antMatchers("/manager/**").hasAnyAuthority("Manager")
                .antMatchers("/employee/**").hasRole("Employee")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(successHandler)
                //.failureUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
//                .exceptionHandling().accessDeniedPage("/accessDenied")
//                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
