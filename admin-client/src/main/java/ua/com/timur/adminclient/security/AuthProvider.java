package ua.com.timur.adminclient.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class AuthProvider implements AuthenticationProvider {


  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserDetails userDetails = new UserDetails(authentication.getName(), authentication.getCredentials().toString());
    log.info("Begin logging procedure for user - {} with password - {}", userDetails.getUserName(), userDetails.getPassword());
    if (userDetails.validate())
      return new UsernamePasswordAuthenticationToken(userDetails, authentication, userDetails.getGrantedAuths());
    return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return aClass.equals(UsernamePasswordAuthenticationToken.class);
  }
}
