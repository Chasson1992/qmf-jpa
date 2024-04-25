package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "system_information")
public class SystemInformation {

    @Id
    @Column(name = "system_information_id", nullable = false)
    private String systemInformationId;

    /** Operating System Name */
    @Column(name = "os_name", updatable = false)
    private String osName;

    @Column(name = "node_name", updatable = false)
    private String nodeName;

    @Column(name = "`release`", updatable = false)
    private String release;

    @Column(name = "version", updatable = false)
    private String version;

    @Column(name = "machine", updatable = false)
    private String machine;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SystemInformation that = (SystemInformation) o;
        return getSystemInformationId() != null && Objects.equals(getSystemInformationId(), that.getSystemInformationId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
