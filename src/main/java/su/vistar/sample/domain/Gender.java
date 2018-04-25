package su.vistar.sample.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genders", schema = "public", catalog = "vetclinic")
public class Gender {
    private Integer id;
    private String type;
    private Collection<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        if (id != null ? !id.equals(gender.id) : gender.id != null) return false;
        if (type != null ? !type.equals(gender.type) : gender.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "gender")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
