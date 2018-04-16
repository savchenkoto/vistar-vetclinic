package su.vistar.web.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "public", catalog = "vetclinic")
public class User {
    private Integer id;
    private String name;
    private Short age;
    private String email;
    private String password;
    private String photo;
    private Collection<Message> sentMessagesById;
    private Collection<Message> receivedMessagesById;
    private Collection<Pet> petsByUserId;
    private Collection<Pet> petsByDoctorId;
    private Role roleByRoleId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "photo", nullable = true, length = 45)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (photo != null ? !photo.equals(user.photo) : user.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userBySenderId")
    public Collection<Message> getSentMessagesById() {
        return sentMessagesById;
    }

    public void setSentMessagesById(Collection<Message> sentMessagesById) {
        this.sentMessagesById = sentMessagesById;
    }

    @OneToMany(mappedBy = "userByReceiverId")
    public Collection<Message> getReceivedMessagesById() {
        return receivedMessagesById;
    }

    public void setReceivedMessagesById(Collection<Message> receivedMessagesById) {
        this.receivedMessagesById = receivedMessagesById;
    }

    @OneToMany(mappedBy = "userByOwnerId")
    public Collection<Pet> getPetsByUserId() {
        return petsByUserId;
    }

    public void setPetsByUserId(Collection<Pet> petsByUserId) {
        this.petsByUserId = petsByUserId;
    }

    @OneToMany(mappedBy = "userByDoctorId")
    public Collection<Pet> getPetsByDoctorId() {
        return petsByDoctorId;
    }

    public void setPetsByDoctorId(Collection<Pet> petsByDoctorId) {
        this.petsByDoctorId = petsByDoctorId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
