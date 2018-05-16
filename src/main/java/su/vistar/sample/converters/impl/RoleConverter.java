package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.RoleEntity;
import su.vistar.sample.dto.regular.RoleDto;

@Component("roleConverter")
public class RoleConverter extends AbstractConverter<RoleEntity, RoleDto> {

    public RoleConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

}
