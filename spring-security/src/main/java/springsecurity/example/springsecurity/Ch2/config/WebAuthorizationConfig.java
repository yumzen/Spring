package springsecurity.example.springsecurity.Ch2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebAuthorizationConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                // .authorizeRequests().anyRequest().authenticated(); // 모든 요청에 인증 필요
                .authorizeRequests().anyRequest().permitAll(); // 인증 없이 요청 가능
        return http.build();
    }
}