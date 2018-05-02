package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.UserEntity;
import su.vistar.sample.domain.VisitEntity;
import su.vistar.sample.dto.ProfileInfoDto;
import su.vistar.sample.dto.VisitPreviewDto;

@Component("profileConverter")
public class ProfileConverter extends AbstractConverter<UserEntity, ProfileInfoDto> {

    private final VisitPreviewConverter visitPreviewConverter;

    private final PetConverter petConverter;

    @Autowired
    public ProfileConverter(ModelMapper modelMapper, VisitPreviewConverter visitPreviewConverter, PetConverter petConverter) {
        super(modelMapper);
        this.visitPreviewConverter = visitPreviewConverter;
        this.petConverter = petConverter;
    }

    public ProfileInfoDto toDto(UserEntity user, VisitEntity visit) {

        ProfileInfoDto profileDto = new ProfileInfoDto();
        profileDto.setName(user.getName());
        profileDto.setAge(user.getAge());
        profileDto.setGender(user.getGender().getType());
        profileDto.setEmail(user.getEmail());
        profileDto.setPhoto(user.getPhoto());
        profileDto.setRole(user.getRole().getType());
        profileDto.setPets(petConverter.toDtos(user.getPets()));
        if (visit != null) {
            VisitPreviewDto visitPreviewDto = visitPreviewConverter.toDto(visit);
            profileDto.setLastVisit(visitPreviewDto);
        } else {
            profileDto.setLastVisit(null);
        }
        return profileDto;

    }

}
