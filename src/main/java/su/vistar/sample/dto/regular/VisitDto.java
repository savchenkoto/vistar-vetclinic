package su.vistar.sample.dto.regular;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.*;
import su.vistar.sample.domain.MedicalCardEntity;
import su.vistar.sample.domain.VisitEntity;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class VisitDto {

    @NonNull
    private Integer id;

    @NonNull
    private Date date;

    @NonNull
    private String description;

    @NonNull
    private String treatment;

    @NonNull
    private Timestamp updatedAt;

    @NonNull
    private MedicalCardEntity medicalCardId;

}
