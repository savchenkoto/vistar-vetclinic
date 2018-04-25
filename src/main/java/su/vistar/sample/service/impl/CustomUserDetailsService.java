package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.domain.User;
import su.vistar.sample.dto.UserDto;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {


    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDto user = userService.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user)
                );
    }

        private List<GrantedAuthority> getAuthorities(UserDto user) {

            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(
                    String.format("ROLE_%s", user.getRole().getType())
            ));
            return grantedAuthorities;

        }
}
