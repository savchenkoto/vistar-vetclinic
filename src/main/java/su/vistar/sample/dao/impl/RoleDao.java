package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.RoleEntity;

@Repository("roleDao")
public class RoleDao extends AbstractDao<RoleEntity, Integer> {

    public RoleDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
