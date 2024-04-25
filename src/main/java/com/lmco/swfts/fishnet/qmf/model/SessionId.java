package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class SessionId {
    private VirtualHostId virtualHostId;

    @Column(name = "name")
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        QueueId queueId = (QueueId)o;
        return getVirtualHostId() != null && Objects.equals(getVirtualHostId(),
                queueId.getVirtualHostId()) && getName() != null && Objects.equals(
                getName(), queueId.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(virtualHostId, name);
    }
}
