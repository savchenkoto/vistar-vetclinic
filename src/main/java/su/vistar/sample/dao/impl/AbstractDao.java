package su.vistar.sample.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import su.vistar.sample.dao.IDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractDao<T, PK extends Serializable> implements IDao<T, PK> {

    private final Class<T> persistentClass;

    @Autowired
    @SuppressWarnings("unchecked")
    public AbstractDao(SessionFactory sessionFactory) {
        this.persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.sessionFactory = sessionFactory;
    }

    private final SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public PK save(T object) {
        return (PK)getSession().save(object);
    }

    public T find(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    public void update(T object) {
        getSession().update(object);
    }

    public void delete(T object) {
        getSession().delete(object);
    }

    public List<T> list() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);
        return getSession().createQuery(criteria).getResultList();
    }


}
