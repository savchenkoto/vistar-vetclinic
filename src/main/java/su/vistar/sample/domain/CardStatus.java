package su.vistar.sample.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "card_statuses", schema = "public", catalog = "vetclinic")
public class CardStatus {
    private Integer id;
    private String type;
    private Collection<MedicalCard> medicalCards;

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

        CardStatus that = (CardStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cardStatus")
    public Collection<MedicalCard> getMedicalCards() {
        return medicalCards;
    }

    public void setMedicalCards(Collection<MedicalCard> medicalCards) {
        this.medicalCards = medicalCards;
    }
}
