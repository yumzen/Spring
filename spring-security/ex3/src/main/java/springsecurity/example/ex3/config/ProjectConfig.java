package springsecurity.example.ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 컨텍스트 소스를 생성해 LDAP 서버의 주소 지정
        var cs = new DefaultSpringSecurityContextSource("ldap://127.0.0.1:33389/dc=springframework,dc=org");
        cs.afterPropertiesSet();

        // LdapUserDetailsManager 인스턴스 생성
        LdapUserDetailsManager manager = new LdapUserDetailsManager(cs);

        // 사용자 이름 매퍼를 설정해 LdapUserDetailsManager에 사용자를 검색하는 방법 지시
        manager.setUsernameMapper(new DefaultLdapUsernameToDnMapper("ou=groups", "uid"));

        // 앱이 사용자를 검색하는 데 필요한 그룹 검색 기준 설정
        manager.setGroupSearchBase("ou=groups");
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .permitAll()
                );
        return http.build();
    }
}