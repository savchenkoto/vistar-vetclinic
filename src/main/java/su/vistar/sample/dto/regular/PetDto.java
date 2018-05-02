package su.vistar.sample.dto.regular;

import lombok.*;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    @NonNull
    private Integer id;

    @NonNull
    private AnimalDto animal;

    @NonNull
    private String name;

    private Date birthdate;

    private String photo;

    @NonNull
    private UserDto owner;

}
