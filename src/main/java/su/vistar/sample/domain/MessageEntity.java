package su.vistar.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "messages", schema = "public", catalog = "vetclinic")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "message", nullable = false, length = -1)
    private String message;

    @Basic
    @Column(name = "delivered_at", nullable = false)
    private Timestamp deliveredAt;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    private UserEntity receiver;

}
