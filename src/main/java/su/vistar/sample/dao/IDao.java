package su.vistar.sample.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T, PK extends Serializable> {

    PK save(T object);

    T find(PK id);

    void update(T object);

    void delete(T object);

    List<T> list();

}
