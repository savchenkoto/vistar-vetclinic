package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.UserEntity;

import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
public class UserDao extends AbstractDao<UserEntity, Integer> {

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public UserEntity findByEmail(String email) {
        UserEntity result = null;
        Query query = getSession().getNamedQuery("User.findByEmail").setParameter("email", email);
        List userEntities = ((org.hibernate.query.Query) query).list();
        if (!userEntities.isEmpty()) {
            result = (UserEntity) userEntities.get(0);
        }
        return result;
    }
}
