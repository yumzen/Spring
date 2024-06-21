package springsecurity.example.ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springsecurity.example.ex3.service.InMemoryUserDetailsService;

import java.util.List;
public class ProjectConfig1 {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u = new User("john", "12345", List.of(new SimpleGrantedAuthority("read")));
        List<UserDetails> users = List.of(u);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}