package su.vistar.web.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "card_statuses", schema = "public", catalog = "vetclinic")
public class CardStatus {
    private Integer id;
    private String status;
    private Collection<MedicalCard> medicalCardsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status ", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardStatus that = (CardStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cardStatusesByStatusId")
    public Collection<MedicalCard> getMedicalCardsById() {
        return medicalCardsById;
    }

    public void setMedicalCardsById(Collection<MedicalCard> medicalCardsById) {
        this.medicalCardsById = medicalCardsById;
    }
}
