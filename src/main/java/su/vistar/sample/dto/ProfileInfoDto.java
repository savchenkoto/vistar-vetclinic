package su.vistar.sample.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import su.vistar.sample.dto.regular.PetDto;
import su.vistar.sample.dto.regular.VisitDto;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class ProfileInfoDto {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    private String photo;

    @NonNull
    private String role;

    @NonNull
    private List<PetDto> pets;

    private VisitPreviewDto lastVisit;

}
