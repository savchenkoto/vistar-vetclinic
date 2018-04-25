package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.Animal;

@Repository("animalDao")
public class AnimalDao extends AbstractDao<Animal, Integer> {

    public AnimalDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
