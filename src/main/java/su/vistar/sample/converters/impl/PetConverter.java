package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.PetEntity;
import su.vistar.sample.dto.regular.PetDto;

@Component("petConverter")
public class PetConverter extends AbstractConverter<PetEntity, PetDto> {

    public PetConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

}
