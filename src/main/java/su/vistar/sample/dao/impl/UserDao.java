package su.vistar.web.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.web.domain.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDao extends AbstractDao<User, Integer> {

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User findByEmail(String email) {

        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("email"), email));
        return getSession().createQuery(criteria).getSingleResult();

    }

}