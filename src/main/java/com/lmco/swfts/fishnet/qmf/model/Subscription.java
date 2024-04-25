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
@Table(name = "subscription")
public class Subscription {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "queue_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "queue_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "queue_name", referencedColumnName = "name")
    })
    private Queue queue;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "session_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "session_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "session_name", referencedColumnName = "name")
    })
    private Session session;

    @Column(name = "browsing", updatable = false)
    private Boolean browsing;

    @Column(name = "acknowledged", updatable = false)
    private Boolean acknowledged;

    @Column(name = "exclusive", updatable = false)
    private Boolean exclusive;

    /** WINDOW or CREDIT */
    @Column(name = "credit_mode", updatable = false)
    private String creditMode;

    @Column(name = "arguments", updatable = false)
    private String arguments;

    /** Total messages delivered */
    @Column(name = "delivered")
    private Long delivered;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Subscription that = (Subscription) o;
        return getName() != null && Objects.equals(getName(), that.getName());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
