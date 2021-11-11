package hu.microservice.medicare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityConfigurationProperties securityProperties;

    @Autowired
    private KeycloakTokenConverter keycloakTokenConverter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (securityProperties.isEnabled()) {
            http.cors().disable().csrf().disable().oauth2ResourceServer().jwt()
                    .jwtAuthenticationConverter(keycloakTokenConverter);
        } else {
            http.authorizeRequests().antMatchers("/").permitAll().and().cors().disable().csrf().disable().httpBasic()
                    .disable();
        }
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        if (securityProperties.isEnabled()) {
            super.configure(web);
        } else {
            web.ignoring().antMatchers("/**");
        }
        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/swagger-ui/**");
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        if (securityProperties.isEnabled()) {
            return NimbusJwtDecoder.withJwkSetUri(securityProperties.getJwksUri()).build();
        } else {
            return null;
        }
    }

}
