package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ExchangeId implements Serializable {

    private VirtualHostId virtualHostId;

    @Column(name = "name")
    private String name;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ExchangeId that = (ExchangeId) o;
        return getVirtualHostId() != null && Objects.equals(getVirtualHostId(), that.getVirtualHostId())
                && getName() != null && Objects.equals(getName(), that.getName());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(virtualHostId, name);
    }
}
