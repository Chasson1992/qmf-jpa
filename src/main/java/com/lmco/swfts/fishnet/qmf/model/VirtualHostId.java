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
public class VirtualHostId implements Serializable {

    @Column(name = "broker_name")
    private String brokerName;

    @Column(name = "name")
    private String name;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        VirtualHostId that = (VirtualHostId) o;
        return getBrokerName() != null && Objects.equals(getBrokerName(), that.getBrokerName())
                && getName() != null && Objects.equals(getName(), that.getName());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(brokerName, name);
    }
}
