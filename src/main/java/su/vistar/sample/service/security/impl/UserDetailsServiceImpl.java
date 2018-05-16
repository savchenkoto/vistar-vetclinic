package su.vistar.sample.service.security.impl;

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
import su.vistar.sample.service.UserService;

import java.util.*;


@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService  {


    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDto user = userService.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        return new User(user.getEmail(), user.getPassword(), true, true,
                true, true, getAuthorities(user)
        );
    }

    private Set<GrantedAuthority> getAuthorities(UserDto user) {

        Set<GrantedAuthority> auths = new HashSet<>();
        auths.add(new SimpleGrantedAuthority(String.format("ROLE_%s", user.getRole().getType())));
        return auths;

    }

}
