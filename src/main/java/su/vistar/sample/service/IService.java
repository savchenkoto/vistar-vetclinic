package su.vistar.sample.service;

import java.io.Serializable;
import java.util.List;

public interface IAbstractService<T, PK extends Serializable> {

    PK save(T newInstance);

    T find(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> findAll();

}