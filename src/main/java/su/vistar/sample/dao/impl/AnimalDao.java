package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.AnimalEntity;

import java.util.List;

@Repository("animalDao")
public class AnimalDao extends AbstractDao<AnimalEntity, Integer> {

    public AnimalDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List findByType(String type) {
        return getSession().getNamedQuery("Animal.findByType").setParameter("type", type).list();
    }

}
