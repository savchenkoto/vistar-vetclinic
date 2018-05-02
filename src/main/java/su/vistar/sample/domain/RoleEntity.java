package su.vistar.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "roles", schema = "public", catalog = "vetclinic")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @OneToMany(mappedBy = "role")
    private Collection<UserEntity> users;

}
