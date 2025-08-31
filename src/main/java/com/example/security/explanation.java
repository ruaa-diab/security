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
roles and admissions:
you can assign more than one role to user.
and because of that you gotta do 2 enums one for the roles D ONE FOR THE PERMISSIONS AND THEN customize to everyRole.
and then we add this dependency:<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>33.4.8-jre</version>
</dependency>     :
Guava is not mandatory, but it gives you ready-to-use tools that make your code cleaner, safer, and shorter.

Many Spring Boot projects use it for collection handling, string utilities, caching, and precondition checks.

now i use those permissons as a parmeter for the roles like
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,ApplicationUserPermission.COURSE_WRITE,ApplicationUserPermission.STUDENT_READ,ApplicationUserPermission.STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;
 and i was able to use Sets.newHashSet() because of guava
 and lastly i edit the role to become.roles(ApplicationUserRole.ADMIN.name())
and name is a ready method to to get literally te name .
--------------------------------------------------------------------------------------------
and now to make only one role access a certain page:
1. we do after permitall .requestMatchers() and u put the path to that certain page and then
.hasRole(and ....)and now u successfuly were able to make a spesific role log in to url .
--------------------------------------------------------------------------------------------------
permission based authentication:




























 */