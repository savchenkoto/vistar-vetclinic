package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.AnimalEntity;

@Repository("animalDao")
public class AnimalDao extends AbstractDao<AnimalEntity, Integer> {

    public AnimalDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
