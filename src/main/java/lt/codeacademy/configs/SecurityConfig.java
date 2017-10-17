package lt.codeacademy.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableOAuth2Sso
@ComponentScan({"lt.codeacademy.dao"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    /* @Override
     protected void configure(HttpSecurity http) throws Exception {
         http.
                 authorizeRequests()
                 .antMatchers("/login","/signin/**","/signup/**").permitAll()
                 .antMatchers("/registration").permitAll()
                 .antMatchers("/registerUser/**").permitAll()
                 .antMatchers("/users").permitAll()
                 .antMatchers("/user").permitAll()
                 .antMatchers("/getShoppingLists/**").permitAll()
                 .antMatchers("/registration/**").permitAll()
 //                .antMatchers("/admin/**").hasAuthority("ADMIN")
 //                .antMatchers("/main").hasAuthority("USER")
                 .anyRequest().authenticated()
                 .and()
                 .formLogin().loginPage("/login").failureUrl("/login?error=true")
                 .usernameParameter("username").passwordParameter("password")
                 .successHandler(securitySuccessHandler)
                 .failureHandler(securityFailureHandler)
                 .and().logout()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                 .and().exceptionHandling().accessDeniedPage("/access-denied")
                 .and().csrf().disable();
     }




     @Override
     protected void configure(AuthenticationManagerBuilder auth)
             throws Exception {
         auth.eraseCredentials(false).
                 jdbcAuthentication().dataSource(dataSource)
 //                .passwordEncoder(passwordEncoder())
                 .usersByUsernameQuery(usersQuery)
                 .authoritiesByUsernameQuery(rolesQuery);
     }

     @Bean
     public ProviderSignInController providerSignInController() {
         ((InMemoryUsersConnectionRepository) usersConnectionRepository)
                 .setConnectionSignUp(facebookConnectionSignup);

         return new ProviderSignInController(
                 connectionFactoryLocator,
                 usersConnectionRepository,
                 new FacebookSignInAdapter());
     }


 }*/
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/login**", "/", "/signin/**","/signup/**", "/users/**", "/createUser", "/user/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/images/**", "/assets/**", "/vendor/**");
    }

}