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
@Table(name = "connection")
public class Connection {

    @EmbeddedId
    private ConnectionId connectionId;


    @MapsId("virtualHostId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "virtual_host_broker_name", referencedColumnName = "broker_name"),
            @JoinColumn(name = "virtual_host_name", referencedColumnName = "name")
    })
    private VirtualHost virtualHost;

    @Column(name = "incoming", updatable = false)
    private Boolean incoming;

    /** authId of connection if authentication enabled */
    @Column(name = "auth_identity", updatable = false)
    private String authIdentity;

    /** Name of executable running as remote client */
    @Column(name = "remote_process_name", length = 65535, updatable = false)
    private String remoteProcessName;

    /** Process ID of remote client */
    @Column(name = "remote_pid", updatable = false)
    private Long remotePid;

    /** Parent Process ID of remote client */
    @Column(name = "remote_parent_pid", updatable = false)
    private Long remoteParentPid;

    /** SASL mechanism */
    @Column(name = "sasl_mechanism", updatable = false)
    private String saslMechanism;

    /** SASL security strength factor */
    @Column(name = "sasl_ssf", updatable = false)
    private Long saslSsf;

    /** optional map of identifying information sent by the remote */
    @Column(name = "remote_properties", updatable = false)
    private String remoteProperties;

    /** protocol in use */
    @Column(name = "protocol", updatable = false)
    private String protocol;

    /** This client is closing by management request */
    @Column(name = "closing")
    private Boolean closing;

    @Column(name = "frames_from_client")
    private Long framesFromClient;

    @Column(name = "frames_to_client")
    private Long framesToClient;

    @Column(name = "bytes_from_client")
    private Long bytesFromClient;

    @Column(name = "bytes_to_client")
    private Long bytesToClient;

    @Column(name = "msgs_from_client")
    private Long msgsFromClient;

    @Column(name = "msgs_to_client")
    private Long msgsToClient;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Connection that = (Connection) o;
        return getConnectionId() != null && Objects.equals(getConnectionId(), that.getConnectionId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(connectionId);
    }
}
