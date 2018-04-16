package su.vistar.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import su.vistar.web.dao.impl.AbstractDao;
import su.vistar.web.service.IService;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public abstract class AbstractService<T, PK extends Serializable> implements IService<T, PK> {

    private AbstractDao<T, PK> classDao;

    public AbstractService() {}

    public AbstractService(AbstractDao<T, PK> dao) {
        classDao = dao;
    }

    public PK save(T newInstance) {
        return classDao.save(newInstance);
    }

    public T find(PK id) {
        return classDao.find(id);
    }

    public void update(T transientObject) {
        classDao.update(transientObject);
    }

    public void delete(T persistentObject) {
        classDao.delete(persistentObject);
    }

    public List<T> findAll() {
        return classDao.list();
    }
}
