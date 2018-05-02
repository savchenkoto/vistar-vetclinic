package su.vistar.sample.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.VisitEntity;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("visitDao")
public class VisitDao extends AbstractDao<VisitEntity, Integer> {

    public VisitDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public VisitEntity getLastVisitByUserId(String userEmail) {
        VisitEntity result = null;
        try {
            result = (VisitEntity) getSession()
                    .getNamedQuery("Visit.getLastByUserEmail").setParameter("userEmail", userEmail).getSingleResult();
        } catch (NoResultException e) { }
        return result;
    }

}
