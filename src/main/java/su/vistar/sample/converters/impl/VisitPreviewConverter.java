package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.VisitEntity;
import su.vistar.sample.dto.VisitPreviewDto;

@Component("visitPreviewConverter")
public class VisitPreviewConverter extends AbstractConverter<VisitEntity, VisitPreviewDto> {

    public VisitPreviewConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public VisitPreviewDto toDto(VisitEntity visitEntity) {

        VisitPreviewDto visitPreviewDto = new VisitPreviewDto();
        visitPreviewDto.setId(visitEntity.getId());
        visitPreviewDto.setDate(visitEntity.getDate());
        visitPreviewDto.setUpdatedAt(visitEntity.getUpdatedAt());
        visitPreviewDto.setPetName(visitEntity.getMedicalCard().getPet().getName());
        visitPreviewDto.setPetId(visitEntity.getMedicalCard().getPet().getId());
        return visitPreviewDto;

    }


}
