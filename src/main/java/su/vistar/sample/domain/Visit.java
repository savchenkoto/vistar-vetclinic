package su.vistar.sample.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "visits", schema = "public", catalog = "vetclinic")
public class Visit {
    private Integer id;
    private Date date;
    private String description;
    private String treatment;
    private Timestamp updatedAt;
    private MedicalCard medicalCard;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "treatment", nullable = false, length = -1)
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (id != null ? !id.equals(visit.id) : visit.id != null) return false;
        if (date != null ? !date.equals(visit.date) : visit.date != null) return false;
        if (description != null ? !description.equals(visit.description) : visit.description != null) return false;
        if (treatment != null ? !treatment.equals(visit.treatment) : visit.treatment != null) return false;
        if (updatedAt != null ? !updatedAt.equals(visit.updatedAt) : visit.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (treatment != null ? treatment.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id", nullable = false)
    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }
}
