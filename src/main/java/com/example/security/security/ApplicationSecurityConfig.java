package com.example.security.security;


import com.sun.source.tree.ReturnTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .requestMatchers("/*","index","/css/*")
               .permitAll()
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();
       return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails ruru = User.builder()
                .username("ruaa-diab")
                .password(this.passwordEncoder.encode("12345"))
                .roles("STUDENT")
                .build();
        UserDetails rose= User.builder()
                .username("rose")
                .password(this.passwordEncoder.encode("12340"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(ruru,rose);
    }


    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}


