package su.vistar.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({
        @NamedQuery(name = "Animal.findByType", query = "from AnimalEntity where type = :type")
})
@Data
@Entity
@Table(name = "animals", schema = "public", catalog = "vetclinic")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @OneToMany(mappedBy = "animal")
    private Collection<PetEntity> pets;



}
