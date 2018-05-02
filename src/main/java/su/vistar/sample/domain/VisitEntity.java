package su.vistar.sample.domain;

import lombok.Data;
import lombok.NonNull;
import su.vistar.sample.dto.regular.VisitDto;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@NamedQueries({
        @NamedQuery(
                name = "Visit.getLastByUserEmail",
                query = "from VisitEntity where medicalCard.pet.owner.email = :userEmail order by date desc"
        )
})
@Data
@Entity
@Table(name = "visits", schema = "public", catalog = "vetclinic")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Basic
    @Column(name = "treatment", nullable = false, length = -1)
    private String treatment;

    @Basic
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id", nullable = false)
    private MedicalCardEntity medicalCard;

    public VisitEntity(@NonNull VisitDto visitDto) {
        this.setId(visitDto.getId());
        this.setDate(visitDto.getDate());
        this.setDescription(visitDto.getDescription());
        this.setTreatment(visitDto.getTreatment());
        this.setUpdatedAt(visitDto.getUpdatedAt());
        this.setMedicalCard(visitDto.getMedicalCardId());
    }

    public VisitEntity() { }

}
