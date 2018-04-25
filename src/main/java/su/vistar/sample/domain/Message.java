package su.vistar.sample.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages", schema = "public", catalog = "vetclinic")
public class Message {
    private Integer id;
    private String message;
    private Timestamp deliveredAt;
    private User sender;
    private User receiver;

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
    @Column(name = "message", nullable = false, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "delivered_at", nullable = false)
    public Timestamp getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Timestamp deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (id != null ? !id.equals(message1.id) : message1.id != null) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (deliveredAt != null ? !deliveredAt.equals(message1.deliveredAt) : message1.deliveredAt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (deliveredAt != null ? deliveredAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
