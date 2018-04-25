package su.vistar.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import su.vistar.web.dao.impl.AbstractDao;
import su.vistar.web.dao.impl.UserDao;
import su.vistar.web.domain.User;


import java.util.List;

@Service("userService")
public class UserService extends AbstractService<User, Integer> {

    private UserDao dao;

    public UserService() {}

    @Autowired
    public UserService(@Qualifier("userDao")AbstractDao<User, Integer> abstractDao) {
        super(abstractDao);
        this.dao = (UserDao) abstractDao;
    }

    public User getUserByEmail(String email) {
        return dao.findByEmail(email);
    }

}
