package su.vistar.sample.dto;

import com.sun.istack.NotNull;
import lombok.*;
import su.vistar.sample.domain.MedicalCard;
import su.vistar.sample.domain.Visit;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class VisitDto {

    private Integer id;

    @NonNull
    private Date date;

    @NonNull
    private String description;

    @NonNull
    private String treatment;

    @NonNull
    private Timestamp updatedAt;

    @NotNull
    private MedicalCard medicalCard;

    public VisitDto(Visit visit) {
        this.setId(visit.getId());
        this.setDate(visit.getDate());
        this.setDescription(visit.getDescription());
        this.setTreatment(visit.getTreatment());
        this.setUpdatedAt(visit.getUpdatedAt());
        this.setMedicalCard(visit.getMedicalCard());
    }

}
