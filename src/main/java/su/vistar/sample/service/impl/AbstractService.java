package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.converters.impl.AbstractConverter;
import su.vistar.sample.dao.impl.AbstractDao;
import su.vistar.sample.service.IService;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class AbstractService<Entity, Dto, PK extends Serializable> implements IService<Dto, PK> {

    private AbstractDao<Entity, PK> dao;

    private final AbstractConverter<Entity, Dto> converter;

    @Autowired
    public AbstractService(AbstractDao<Entity, PK> dao, AbstractConverter<Entity, Dto> converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    @Transactional
    public PK save(Dto object) {
        return dao.save(converter.toEntity(object));
    }

    @Override
    @Transactional(readOnly = true)
    public Dto find(PK id) {
        return converter.toDto(dao.find(id));
    }

    @Override
    @Transactional
    public void update(Dto object) {
        dao.update(converter.toEntity(object));
    }

    @Override
    @Transactional
    public void delete(Dto object) {
        dao.delete(converter.toEntity(object));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dto> findAll() {
        return converter.toDtos(dao.list());
    }

}
