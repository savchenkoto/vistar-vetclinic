package su.vistar.web.dao.impl;

import org.springframework.stereotype.Repository;
import su.vistar.web.domain.Animal;

@Repository("animalDao")
public class AnimalDao extends AbstractDao<Animal, Integer> {


}
