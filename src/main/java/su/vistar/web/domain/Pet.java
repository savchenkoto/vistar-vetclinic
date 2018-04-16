package su.vistar.web.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "pets", schema = "public", catalog = "vetclinic")
public class Pet {
    private Integer id;
    private String name;
    private Date birthdate;
    private String photo;
    private Collection<MedicalCard> medicalCardsById;
    private Animal animalByTypeId;
    private User userByOwnerId;
    private User userByDoctorId;

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
    @Column(name = "birthdate", nullable = true)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

        Pet pet = (Pet) o;

        if (id != null ? !id.equals(pet.id) : pet.id != null) return false;
        if (name != null ? !name.equals(pet.name) : pet.name != null) return false;
        if (birthdate != null ? !birthdate.equals(pet.birthdate) : pet.birthdate != null) return false;
        if (photo != null ? !photo.equals(pet.photo) : pet.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "petByPetId")
    public Collection<MedicalCard> getMedicalCardsById() {
        return medicalCardsById;
    }

    public void setMedicalCardsById(Collection<MedicalCard> medicalCardsById) {
        this.medicalCardsById = medicalCardsById;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public Animal getAnimalByTypeId() {
        return animalByTypeId;
    }

    public void setAnimalByTypeId(Animal animalByTypeId) {
        this.animalByTypeId = animalByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    public User getUserByOwnerId() {
        return userByOwnerId;
    }

    public void setUserByOwnerId(User userByOwnerId) {
        this.userByOwnerId = userByOwnerId;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    public User getUserByDoctorId() {
        return userByDoctorId;
    }

    public void setUserByDoctorId(User userByDoctorId) {
        this.userByDoctorId = userByDoctorId;
    }
}
