package ua.com.timur.adminclient.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetails {

  String userName;
  String password;

  List<GrantedAuthority> grantedAuths = new ArrayList<>();

  public UserDetails(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public boolean validate() {
    if("timur".equalsIgnoreCase(userName) && "123456".equals(password))
      grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));
    else if ("guest".equalsIgnoreCase(userName) && "000000".equals(password))
      grantedAuths.add(new SimpleGrantedAuthority("GUEST"));
    else
      throw new BadCredentialsException("Bad credentials!!!");
    return true;
  }
}
