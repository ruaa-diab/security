package com.example.security;
/*

basic auth



    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
       http
               .authorizeRequests()
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();
       return http.build();
   }
   authenticate everything with basic authentication.
   thats is it it is a pop up you sigun in and thr re enter the right url.
   you can tlog out here
   --------------------------------------------------------------------------------
basic authentication part 2 which pages that dont need it :
authorizeRequests()
               .requestMatchers("/*","index","/css/*")
               .permitAll()   so now these in url means no sign in.

  ------------------------------------------------------------------------------------
inmemory user/s:
another bean this one to tell spring security whao are the sers and thier rolesssss

  UserDetails user=User.builder--->so automatically encodes te password so spring security can check it
  .username
  .password--->the password must be encoded. and here we add the encoder object
  .roles
  ,build
  here we r creation a single user
  Second bean (InMemoryUserDetailsManager) → acts as a user manager that stores usernames, passwords, and roles in memory and checks them when someone logs in.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
encoding the password:
first of all you do a class andchoose the algorithm u want to use and strength:

@Configuration
public class PasswordConfig {

@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(10);
}

} and then u put it besid the password and spring security wont let u proceed without doing so.
----------------------------------------------------------------------------------------------------

























 */