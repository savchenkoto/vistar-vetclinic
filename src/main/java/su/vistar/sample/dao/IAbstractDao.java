package su.vistar.web.dao;

import java.io.Serializable;
import java.util.List;

public interface IAbstractDao<T, PK extends Serializable> {

    PK save(T newInstance);

    T find(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> list();

}
