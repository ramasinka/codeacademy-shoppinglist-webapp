package lt.codeacademy.configs;

import lt.codeacademy.handler.SecurityFailureHandler;
import lt.codeacademy.handler.SecuritySuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan({"lt.codeacademy.dao"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private DataSource dataSource;

    @Resource
    private SecuritySuccessHandler securitySuccessHandler;

    @Resource
    private SecurityFailureHandler securityFailureHandler;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error=true")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(securitySuccessHandler)
                .failureHandler(securityFailureHandler)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/access-denied");
//                .and().csrf();
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/images/**", "/assets/**", "/vendor/**");
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
}
