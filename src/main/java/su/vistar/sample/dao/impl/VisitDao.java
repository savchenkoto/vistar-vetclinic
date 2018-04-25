package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.dao.IAbstractDao;
import su.vistar.sample.domain.Visit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("visitDao")
public class VisitDao extends  AbstractDao<Visit, Integer> {

    public VisitDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Visit> findByUserId(Integer userId) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Visit> criteria = builder.createQuery(Visit.class);
        Root<Visit> root = criteria.from(Visit.class);
        criteria.select(root).where(builder.equal(root.get("user_id"), userId));
        return getSession().createQuery(criteria).list();
    }
}
