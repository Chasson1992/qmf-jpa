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
@Table(name = "virtual_host")
public class VirtualHost {

    @EmbeddedId
    private VirtualHostId virtualHostId;

    @Column(name = "federation_tag", updatable = false)
    private String federationTag;

    @MapsId("brokerName")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "broker_name")
    private Broker broker;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        VirtualHost that = (VirtualHost) o;
        return getVirtualHostId() != null && Objects.equals(getVirtualHostId(), that.getVirtualHostId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(virtualHostId);
    }
}
