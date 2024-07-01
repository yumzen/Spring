package springsecurity.example.ex51.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private UserDetailsService userDetailsService; //useDetails 가져오기 위함

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserDetails u = userDetailsService.loadUserByUsername(username);
    //사용자 이름을 찾으면 컨텏트에서 PasswordEncoder의 matches()메서드로 사용자의 암호를 확인할 수 있음
    if (passwordEncoder.matches(password, u.getPassword())) {
      return new UsernamePasswordAuthenticationToken(username, password, u.getAuthorities());
      //암호 일치하면 필요한 세부 정보가 포함된 Authentication 계약의 구현을 반환
    } else {
      throw new BadCredentialsException("Something went wrong!");
      //암호 일치 하지 않으면 AuthenticationException 형식의 예외 throw!
    }
  }

  @Override
  public boolean supports(Class<?> authenticationType) {
    return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
  }
}