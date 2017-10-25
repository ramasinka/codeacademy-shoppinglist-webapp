package lt.codeacademy.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    private static final String RESOURCE_ID = "client1";
//
//    @Value("${security.oauth2.client.clientId}")
//    private String clientId;
//
//    @Value("${security.oauth2.client.clientSecret}")
//    private String clientSecret;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/login/**", "/signin/**", "/signup/**", "/users/**", "/createUser", "/user/**", "/logout/**",
//                        "/getShoppingLists")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().logout().logoutSuccessUrl("http://localhost:8081/auth/logout")
//                .and().csrf().disable();
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        RemoteTokenServices tokenService = new RemoteTokenServices();
//        tokenService.setClientId(clientId);
//        tokenService.setClientSecret(clientSecret);
//        tokenService.setCheckTokenEndpointUrl("http://localhost:8081/auth/check_token");
//
//        resources.resourceId(RESOURCE_ID).tokenServices(tokenService);
//    }
//}