package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.UserEntity;
import su.vistar.sample.domain.VisitEntity;

import javax.persistence.Query;

@Repository("userDao")
public class UserDao extends AbstractDao<UserEntity, Integer> {

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public UserEntity findByEmail(String email) {
        Query query = getSession().getNamedQuery("User.findByEmail").setParameter("email", email);
        return (UserEntity) query.getSingleResult();
    }
}
