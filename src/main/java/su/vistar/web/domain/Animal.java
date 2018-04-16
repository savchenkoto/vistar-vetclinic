package su.vistar.web.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "animals", schema = "public", catalog = "vetclinic")
public class Animal {
    private Integer id;
    private String animal;
    private Collection<Pet> petsById;

    public Animal() {
    }

    public Animal(String animal) {
        this.animal = animal;
    }

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
    @Column(name = "animal", nullable = false, length = 45)
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal1 = (Animal) o;

        if (id != null ? !id.equals(animal1.id) : animal1.id != null) return false;
        if (animal != null ? !animal.equals(animal1.animal) : animal1.animal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (animal != null ? animal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "animalByTypeId")
    public Collection<Pet> getPetsById() {
        return petsById;
    }

    public void setPetsById(Collection<Pet> petsById) {
        this.petsById = petsById;
    }
}
