package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import su.vistar.sample.converters.Convertible;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class AbstractConverter<Entity, Dto> implements Convertible<Entity, Dto> {

    private final Class<Entity> entityClass;

    private final Class<Dto> dtoClass;

    protected final ModelMapper modelMapper;


    @Autowired
    @SuppressWarnings("unchecked")
    public AbstractConverter(ModelMapper modelMapper) {
        this.entityClass = (Class<Entity>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dtoClass = (Class<Dto>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.modelMapper = modelMapper;
    }

    @Override
    public Dto toDto(Entity entity) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public Entity toEntity(Dto dto) {
        return modelMapper.map(dto, entityClass);
    }

    @Override
    public List<Dto> toDtos(Collection<Entity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Entity> toEntities(Collection<Dto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
