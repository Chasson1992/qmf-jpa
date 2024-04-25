package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "session")
public class Session {

    @EmbeddedId
    private SessionId sessionId;

    @MapsId("virtualHostId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "virtual_host_broker_name", referencedColumnName = "broker_name"),
            @JoinColumn(name = "virtual_host_name", referencedColumnName = "name")
    })
    private VirtualHost virtualHost;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "connection_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "connection_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "connection_address", referencedColumnName = "address")
    })
    private Connection connection;

    @Column(name = "full_name", length = 65535, updatable = false)
    private String fullName;

    @Column(name = "channel_id", updatable = false)
    private Long channelId;

    @Column(name = "attached", updatable = false)
    private Boolean attached;

    /** Time session will expire in nanoseconds since epoch */
    @Column(name = "expire_time", updatable = false)
    private Long expireTime;

    /** Number of uUnacknowledged messages in session */
    @Column(name = "unacked_messages")
    private Long unackedMessages;

    /** Total number of started transactions in session */
    @Column(name = "txn_starts")
    private Long txnStarts;

    /** Total number of committed transactions in session */
    @Column(name = "txn_commits")
    private Long txnCommits;

    /** Total number of rejected transactions in session */
    @Column(name = "txn_rejects")
    private Long txnRejects;

    /** Total number of transactions in session */
    @Column(name = "txn_count")
    private Long txnCount;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Session session = (Session) o;
        return getSessionId() != null && Objects.equals(getSessionId(), session.getSessionId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(sessionId);
    }
}
