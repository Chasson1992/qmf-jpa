package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ConnectionId {
    private VirtualHostId virtualHostId;

    @Column(name = "address")
    private String address;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ConnectionId that = (ConnectionId) o;
        return getVirtualHostId() != null && Objects.equals(getVirtualHostId(), that.getVirtualHostId())
                && getAddress() != null && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(virtualHostId, address);
    }
}
