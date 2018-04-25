package su.vistar.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.web.dao.impl.UserDao;
import su.vistar.web.domain.Role;
import su.vistar.web.domain.User;

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

        User user = userService.getUserByEmail(email);
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

        private List<GrantedAuthority> getAuthorities(User user) {

            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(
                    String.format("ROLE_%s", user.getRoleByRoleId().getRole())
            ));
            return grantedAuthorities;

        }
}
