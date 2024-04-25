package com.lmco.swfts.fishnet.qmf.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "queue")
public class Queue {

    @EmbeddedId
    private QueueId queueId;

    @Column(name = "durable", updatable = false)
    private Boolean durable;

    @MapsId("virtualHostId")
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "virtual_host_broker_name", referencedColumnName = "broker_name"),
        @JoinColumn(name = "virtual_host_name", referencedColumnName = "name")
    })
    private VirtualHost virtualHost;

    @Column(name = "auto_delete", updatable = false)
    private Boolean autoDelete;

    @Column(name = "exclusive", updatable = false)
    private Boolean exclusive;

    /** Arguments supplied in queue.declare */
    @Column(name = "arguments", updatable = false)
    private String arguments;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumns({
            @JoinColumn(name = "exchange_virtual_host_broker_name", referencedColumnName = "virtual_host_broker_name"),
            @JoinColumn(name = "exchange_virtual_host_name", referencedColumnName = "virtual_host_name"),
            @JoinColumn(name = "exchange_name", referencedColumnName = "name")
    })
    private Exchange altExchange;

    /** Total messages enqueued */
    @Column(name = "msg_total_enqueues")
    private Long msgTotalEnqueues;

    /** Total messages dequeued */
    @Column(name = "msg_total_dequeues")
    private Long msgTotalDequeues;

    /** Transactional messages enqueued */
    @Column(name = "msg_txn_enqueues")
    private Long msgTxnEnqueues;

    /** Transactional messages dequeued */
    @Column(name = "msg_txn_dequeues")
    private Long msgTxnDequeues;

    /** Persistent messages enqueued */
    @Column(name = "msg_persist_enqueues")
    private Long msgPersistEnqueues;

    /** Persistent messages dequeued */
    @Column(name = "msg_persist_dequeues")
    private Long msgPersistDequeues;

    /** Current number of messages on queues calculated by subtracting msgTotalDequeues from msgTotalEnqueues */
    @Column(name = "msg_depth")
    private Long msgDepth;

    /** Current number of bytes on queues calculated by subtracting byteTotalDequeues from byteTotalEnqueues */
    @Column(name = "byte_depth")
    private Long byteDepth;

    /** Total bytes enqueued */
    @Column(name = "byte_total_enqueues")
    private Long byteTotalEnqueues;

    /** Total bytes dequeued */
    @Column(name = "byte_total_dequeues")
    private Long byteTotalDequeues;

    /** Transactional bytes enqueued */
    @Column(name = "byte_txn_enqueues")
    private Long byteTxnEnqueues;

    /** Transactional bytes dequeued */
    @Column(name = "byte_txn_dequeues")
    private Long byteTxnDequeues;

    /** Persistent bytes enqueued */
    @Column(name = "byte_persist_enqueues")
    private Long bytePersistEnqueues;

    /** Persistent bytes dequeued */
    @Column(name = "byte_persist_dequeues")
    private Long bytePersistDequeues;

    /** Acquired messages reinserted into the queue */
    @Column(name = "releases")
    private Long releases;

    /** Messages acquired from the queue */
    @Column(name = "acquires")
    private Long acquires;

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

    /** Current consumers on the queue */
    @Column(name = "consumer_count")
    private Long consumerCount;

    /** Current bindings on the queue */
    @Column(name = "binding_count")
    private Long bindingCount;

    /** Flow control active */
    @Column(name = "flow_stopped")
    private Boolean flowStopped;

    /** Number of times flow control was activated for this queue */
    @Column(name = "flow_stopped_count")
    private Long flowStoppedCount;

    /** Partner queue for redirected pair */
    @Column(name = "redirect_peer")
    private String redirectPeer;

    /** Source queue for redirected pair */
    @Column(name = "redirect_source")
    private Boolean redirectSource;

    /** userId of creator of the queue */
    @Column(name = "creator")
    private String creator;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Queue queue = (Queue) o;
        return getQueueId() != null && Objects.equals(getQueueId(), queue.getQueueId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(queueId);
    }
}
