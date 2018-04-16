package su.vistar.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import su.vistar.web.dao.impl.AbstractDao;
import su.vistar.web.dao.impl.AnimalDao;
import su.vistar.web.domain.Animal;

import javax.transaction.Transactional;

@Service("animalService")
public class AnimalService extends AbstractService<Animal, Integer> {

    private AnimalDao dao;

    public AnimalService() {}

    @Autowired
    public AnimalService(@Qualifier("animalDao") AbstractDao<Animal, Integer> abstractDao) {
        super(abstractDao);
        this.dao = (AnimalDao) abstractDao;
    }


}
