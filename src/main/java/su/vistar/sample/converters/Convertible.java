package su.vistar.sample.converters;

import java.util.Collection;
import java.util.List;

public interface Convertible<Entity, Dto> {

    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    List<Dto> toDtos(final Collection<Entity> entities);

    List<Entity> toEntities(final Collection<Dto> dtos);

}
