package su.vistar.web.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "medical_cards", schema = "public", catalog = "vetclinic")
public class MedicalCard {
    private Integer id;
    private Date applicationDate;
    private Integer closingDate;
    private Pet petByPetId;
    private CardStatus cardStatusesByStatusId;
    private Collection<Visit> visitsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "application_date", nullable = false)
    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    @Basic
    @Column(name = "closing_date", nullable = false)
    public Integer getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Integer closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicalCard that = (MedicalCard) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (applicationDate != null ? !applicationDate.equals(that.applicationDate) : that.applicationDate != null)
            return false;
        if (closingDate != null ? !closingDate.equals(that.closingDate) : that.closingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applicationDate != null ? applicationDate.hashCode() : 0);
        result = 31 * result + (closingDate != null ? closingDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    public Pet getPetByPetId() {
        return petByPetId;
    }

    public void setPetByPetId(Pet petByPetId) {
        this.petByPetId = petByPetId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public CardStatus getCardStatusesByStatusId() {
        return cardStatusesByStatusId;
    }

    public void setCardStatusesByStatusId(CardStatus cardStatusesByStatusId) {
        this.cardStatusesByStatusId = cardStatusesByStatusId;
    }

    @OneToMany(mappedBy = "medicalCardByMedicalCardId")
    public Collection<Visit> getVisitsById() {
        return visitsById;
    }

    public void setVisitsById(Collection<Visit> visitsById) {
        this.visitsById = visitsById;
    }
}
