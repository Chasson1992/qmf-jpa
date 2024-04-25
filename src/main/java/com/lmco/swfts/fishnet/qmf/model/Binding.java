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
@Entity
@ToString
@Table(name = "binding")
public class Binding {

    @Id
    @Column(name = "binding_key", nullable = false, updatable = false)
    private String bindingKey;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "queue_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "queue_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "queue_name", referencedColumnName = "name")
    })
    private Queue queue;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "exchange_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "exchange_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "exchange_name", referencedColumnName = "name")
    })
    private Exchange exchange;


    @Column(name = "msg_matched")
    private Long msgMatched;

    @Column(name = "arguments", updatable = false)
    private String arguments;

    @Column(name = "origin", updatable = false)
    private String origin;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Binding binding = (Binding) o;
        return getBindingKey() != null && Objects.equals(getBindingKey(), binding.getBindingKey());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
