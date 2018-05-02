package su.vistar.sample.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import su.vistar.sample.dto.regular.PetDto;
import su.vistar.sample.dto.regular.VisitDto;

import java.util.Collection;

@Data
@NoArgsConstructor
public class ProfileInfoDto {

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String gender;

    private Short age;

    private String photo;

    @NonNull
    private String role;

    private Collection<PetDto> pets;

    private VisitPreviewDto lastVisit;

}
