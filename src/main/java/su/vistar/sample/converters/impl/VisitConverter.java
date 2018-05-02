package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.VisitEntity;
import su.vistar.sample.dto.regular.VisitDto;

@Component("visitConverter")
public class VisitConverter extends AbstractConverter<VisitEntity, VisitDto> {

    public VisitConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

}
