package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.AnimalEntity;
import su.vistar.sample.dto.regular.AnimalDto;

@Component("animalConverter")
public class AnimalConverter extends AbstractConverter<AnimalEntity, AnimalDto> {

    public AnimalConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

}
