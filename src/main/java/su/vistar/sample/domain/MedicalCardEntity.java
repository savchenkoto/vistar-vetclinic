package su.vistar.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "medical_cards", schema = "public", catalog = "vetclinic")
public class MedicalCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "application_date", nullable = false)
    private Date applicationDate;

    @Basic
    @Column(name = "closing_date", nullable = true)
    private Integer closingDate;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private UserEntity doctor;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private CardStatusEntity cardStatus;

    @OneToMany(mappedBy = "medicalCard")
    private Collection<VisitEntity> visits;

}
