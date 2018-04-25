package su.vistar.sample.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "medical_cards", schema = "public", catalog = "vetclinic")
public class MedicalCard {
    private Integer id;
    private Date applicationDate;
    private Integer closingDate;
    private Pet pet;
    private CardStatus cardStatus;
    private Collection<Visit> visits;

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
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    @OneToMany(mappedBy = "medicalCard")
    public Collection<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Collection<Visit> visits) {
        this.visits = visits;
    }
}
