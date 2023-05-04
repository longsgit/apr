* Create a Spring Boot application __my-secured-app__ by selecting __Spring Web__ and __Spring security__ templates

* Create a Sample Controller

``` java

@RestController
public class SampleController {

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}

	@GetMapping("/home")
	public String home() {
		return "Welcome to home screen";
	}
}
```

* Launch the application
* default username is __user__ and password is generated for you. You will find it in the console
* For example console shows __Using generated security password: 5fd13e36-d18f-4e48-befd-ea73e2556559__
* Access the application **http://localhost:8080/home** (*incognito window, if required*) and enter the credentials
* You can customize the credentials

``` yml

spring:
  security:
    user:
      name: sam
      password: sam123

```

* Try running the application now.



* Let's secure __/home__

* Create the following class and configure settings

``` java

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .antMatchers("/home/**")
                        .authenticated())
                .formLogin();

        http
                .authorizeRequests((authz) -> authz
                        .anyRequest().permitAll()
                );
        return http.build();
    }

}

```

* Try accessing __/hello/sam__ and __/home__ and observe the difference

* Now let's replace our default credentials in yml and add the following

``` java

	@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User
                .builder()
                .username("user")
                .password("{noop}password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

```

* Try accessing __/hello/sam__ and __/home__ and observe the difference

* You can replace the in memory authentication with database/ldap authentication providers. __Discussed in the class__

