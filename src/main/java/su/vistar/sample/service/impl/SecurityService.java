package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.dto.regular.UserDto;

import java.util.*;


@Service("customUserDetailsService")
public class SecurityService implements UserDetailsService {


    private final UserService userService;

    @Autowired
    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDto user = userService.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user)
                );
    }

    private Set<GrantedAuthority> getAuthorities(UserDto user) {

        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(String.format("ROLE_%s", user.getRole().getType())));
        return auths;

    }


}
