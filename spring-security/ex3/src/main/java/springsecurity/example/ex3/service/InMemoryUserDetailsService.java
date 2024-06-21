package springsecurity.example.ex3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users; //메모리 내 사용자 목록을 관리

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(u -> u.getUsername().equals(username)) //일치하는 항목 필터링
                .findFirst() //일치하는 사용자가 있으면 반환
                .orElseThrow(() -> new UsernameNotFoundException("User not found")); //존재하지 않으면 예외
    }
}