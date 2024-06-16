package springsecurity.example.springsecurity.Ch2.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        //인증논리 코드
        String username = authentication.getName(); //Principal 인터페이스의 getName() 메서드를 Authentication에서 상속받는다.
        String password = String.valueOf(authentication.getCredentials());

        if ("john".equals(username) && "12345".equals(password)) { //UserDetailsService 및 PasswordEncoder를 호출해서 사용자 이름과 암호를 테스트한다.
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticatonType){
        //Authentication 형식의 구현을 추가(CustomAuthenticationProvider가 특정 Authentication 형식을 지원하는지 여부를 확인)
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticatonType);
    }
}
