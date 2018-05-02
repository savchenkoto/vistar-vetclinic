package su.vistar.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "pets", schema = "public", catalog = "vetclinic")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;

    @Basic
    @Column(name = "photo", nullable = true, length = 45)
    private String photo;

    @OneToMany(mappedBy = "pet")
    private Collection<MedicalCardEntity> medicalCards;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private AnimalEntity animal;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private UserEntity owner;

}
