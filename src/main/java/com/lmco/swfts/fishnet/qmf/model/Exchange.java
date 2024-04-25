package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "exchange")
public class Exchange {
    @EmbeddedId
    private ExchangeId exchangeId;

    @MapsId("virtualHostId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "virtual_host_broker_name", referencedColumnName = "broker_name"),
            @JoinColumn(name = "virtual_host_name", referencedColumnName = "name")
    })
    private VirtualHost virtualHost;

    @Column(name = "type", updatable = false)
    private String type;

    @Column(name = "durable", updatable = false)
    private Boolean durable;

    @Column(name = "auto_delete", updatable = false)
    private Boolean autoDelete;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumns({
            @JoinColumn(name = "exchange_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "exchange_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "exchange_name", referencedColumnName = "name")
    })
    private Exchange altExchange;

    /** Arguments supplied in exchange.declare */
    @Column(name = "arguments", updatable = false)
    private String arguments;

    /** Current bindings */
    @Column(name = "binding_count")
    private Long bindingCount;

    /** Total messages received */
    @Column(name = "msg_receives")
    private Long msgReceives;

    /** Total messages dropped (no matching binding key) */
    @Column(name = "msg_drops")
    private Long msgDrops;

    /** Total routed messages */
    @Column(name = "msg_routes")
    private Long msgRoutes;

    /** Total bytes received */
    @Column(name = "byte_receives")
    private Long byteReceives;

    /** Total bytes dropped (no matching binding key) */
    @Column(name = "byte_drops")
    private Long byteDrops;

    /** Total routed bytes */
    @Column(name = "byte_routes")
    private Long byteRoutes;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Exchange exchange = (Exchange) o;
        return getExchangeId() != null && Objects.equals(getExchangeId(), exchange.getExchangeId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(exchangeId);
    }
}
