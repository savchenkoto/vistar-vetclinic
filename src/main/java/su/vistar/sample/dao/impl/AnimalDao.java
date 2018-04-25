package su.vistar.web.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.web.domain.Animal;

@Repository("animalDao")
public class AnimalDao extends AbstractDao<Animal, Integer> {

    public AnimalDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
