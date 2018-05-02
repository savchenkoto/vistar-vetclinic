package su.vistar.sample.dto.regular;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MedicalCardDto {

    @NonNull
    private Integer id;

    @NonNull
    private Date applicationDate;

    private Date closingDate;

    @NonNull
    private PetDto pet;

    @NonNull
    private UserDto doctor;

    @NonNull
    private CardStatusDto cardStatus;

}
