package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "broker")
public class Broker {

    /** Index for the broker at this agent */
    @Id
    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    /** SystemInformation ID */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "system_information_id")
    private SystemInformation system;

    /** TCP Port for AMQP Service */
    @Column(name = "port", updatable = false)
    private Long port;

    /** Thread pool size */
    @Column(name = "worker_threads", updatable = false)
    private Long workerThreads;

    /** Maximum allowed connections */
    @Column(name = "max_conns", updatable = false)
    private Long maxConns;

    /** Connection backlog limit for listening socket */
    @Column(name = "conn_backlog", updatable = false)
    private Long connBacklog;

    /** Broker's management agent sends unsolicited data on the publish interval */
    @Column(name = "mgmt_publish", updatable = false)
    private Boolean mgmtPublish;

    /** Interval for management broadcasts */
    @Column(name = "mgmt_pub_interval", updatable = false)
    private Long mgmtPubInterval;

    /** Running software version */
    @Column(name = "version", updatable = false)
    private String version;

    /** Persistent configuration storage location */
    @Column(name = "data_dir", length = 65535, updatable = false)
    private String dataDir;

    /** Delta time in nanoseconds since the broker has come online */
    @Column(name = "uptime")
    private Long uptime;

    /** Number of queues in the broker */
    @Column(name = "queue_count")
    private Long queueCount;

    /** Total messages enqueued to broker */
    @Column(name = "msg_total_enqueues")
    private Long msgTotalEnqueues;

    /** Total messages dequeued from broker */
    @Column(name = "msg_total_dequeues")
    private Long msgTotalDequeues;

    /** Total bytes enqueued to broker */
    @Column(name = "byte_total_enqueues")
    private Long byteTotalEnqueues;

    /** Total bytes dequeued from broker */
    @Column(name = "byte_total_dequeues")
    private Long byteTotalDequeues;

    /** Current number of messages on queues in broker calculated by subtracting msgTotalDequeues from msgTotalEnqueues */
    @Column(name = "msg_depth")
    private Long msgDepth;

    /** Current number of bytes on queues in broker calculated by subtracting byteTotalDequeues from byteTotalEnqueues */
    @Column(name = "byte_depth")
    private Long byteDepth;

    /** Total persistent messages enqueued to broker */
    @Column(name = "msg_persist_enqueues")
    private Long msgPersistEnqueues;

    /** Total persistent bytes enqueued to broker */
    @Column(name = "msg_persist_dequeues")
    private Long msgPersistDequeues;

    /** Total persistent bytes enqueued to broker */
    @Column(name = "byte_persist_enqueues")
    private Long bytePersistEnqueues;

    /** Total persistent bytes dequeued from broker */
    @Column(name = "byte_persist_dequeues")
    private Long bytePersistDequeues;

    /** Total transactional messages enqueued to broker */
    @Column(name = "msg_txn_enqueues")
    private Long msgTxnEnqueues;

    /** Total transactional messages dequeued from broker */
    @Column(name = "msg_txn_dequeues")
    private Long msgTxnDequeues;

    /** Total transactional bytes enqueued to broker */
    @Column(name = "byte_txn_enqueues")
    private Long byteTxnEnqueues;

    /** Total transactional bytes dequeued from broker */
    @Column(name = "byte_txn_dequeues")
    private Long byteTxnDequeues;

    /** Acquired messages reinserted into the queue */
    @Column(name = "releases")
    private Long releases;

    /** Messages acquired from the queue */
    @Column(name = "acquires")
    private Long acquires;

    /** Messages discarded due to no-route from exchange */
    @Column(name = "discards_no_route")
    private Long discardsNoRoute;

    /** Messages discarded due to TTL expiration */
    @Column(name = "discards_ttl")
    private Long discardsTtl;

    /** Messages discarded due to ring-queue overflow */
    @Column(name = "discards_ring")
    private Long discardsRing;

    /** Messages discarded due to LVQ insert */
    @Column(name = "discards_lvq")
    private Long discardsLvq;

    /** Messages discarded due to reject-policy overflow */
    @Column(name = "discards_overflow")
    private Long discardsOverflow;

    /** Messages discarded due to subscriber reject */
    @Column(name = "discards_subscriber")
    private Long discardsSubscriber;

    /** Messages discarded due to management purge */
    @Column(name = "discards_purge")
    private Long discardsPurge;

    /** Messages dequeued to management re-route */
    @Column(name = "reroutes")
    private Long reroutes;

    /** Messages left in a deleted queue */
    @Column(name = "abandoned")
    private Long abandoned;

    /** Messages routed to alternate exchange from a deleted queue */
    @Column(name = "abandoned_via_alt")
    private Long abandonedViaAlt;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Broker broker = (Broker) o;
        return getName() != null && Objects.equals(getName(), broker.getName());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

