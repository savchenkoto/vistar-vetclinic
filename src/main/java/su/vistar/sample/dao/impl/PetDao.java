package su.vistar.sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import su.vistar.sample.domain.PetEntity;

@Repository("petDao")
public class PetDao extends AbstractDao<PetEntity, Integer> {

    public PetDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
