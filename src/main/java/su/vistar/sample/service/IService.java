package su.vistar.sample.service;

import java.io.Serializable;
import java.util.List;

public interface IService<Dto, PK extends Serializable> {

    PK save(Dto object);

    Dto find(PK id);

    void update(Dto object);

    void delete(Dto object);

    List<Dto> findAll();

}
