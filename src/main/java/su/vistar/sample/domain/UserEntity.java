package su.vistar.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "from UserEntity where email = :email")
})
@Data
@Entity
@Table(name = "users", schema = "public", catalog = "vetclinic")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Basic
    @Column(name = "photo", nullable = true, length = 45)
    private String photo;

    @OneToMany(mappedBy = "sender")
    private Collection<MessageEntity> sentMessages;

    @OneToMany(mappedBy = "receiver")
    private Collection<MessageEntity> receivedMessages;

    @OneToMany(mappedBy = "owner")
    private Collection<PetEntity> pets;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity role;

}
