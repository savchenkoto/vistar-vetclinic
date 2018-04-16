package su.vistar.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import su.vistar.web.dao.IAbstractDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractDao<T, PK extends Serializable> implements IAbstractDao<T, PK> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public PK save(T newInstance) {
        return (PK)getSession().save(newInstance);
    }

    public T find(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    public void update(T transientObject) {
        getSession().update(transientObject);
    }

    public void delete(T persistentObject) {
        getSession().delete(persistentObject);
    }

    public List<T> list() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);
        return getSession().createQuery(criteria).getResultList();
    }


}
