package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BrokerRepository extends JpaRepository<Broker, String> {

    @Transactional
    @Modifying
    @Query("update Broker b set b.uptime = :uptime, b.queueCount = :queueCount, b.msgDepth = :msgDepth, b.byteDepth = :byteDepth, b.byteTotalEnqueues = :byteTotalEnqueues, " +
            "b.byteTotalDequeues = :byteTotalDequeues, b.msgTotalEnqueues = :msgTotalEnqueues, b.msgTotalDequeues = :msgTotalDequeues, " +
            "b.discardsNoRoute = :discardsNoRoute, b.discardsTtl = :discardsTtl, b.discardsRing = :discardsRing, b.discardsLvq = :discardsLvq, " +
            "b.discardsOverflow = :discardsOverflow, b.discardsSubscriber = :discardsSubscriber, b.discardsPurge = :discardsPurge, " +
            "b.abandoned = :abandoned where b.name = :name")
    void updateStatisticsByName(Long uptime, Long queueCount, Long msgDepth, Long byteDepth, Long byteTotalEnqueues,
                                      Long byteTotalDequeues, Long msgTotalEnqueues, Long msgTotalDequeues,
                                      Long discardsNoRoute, Long discardsTtl, Long discardsRing,
                                      Long discardsLvq, Long discardsOverflow, Long discardsSubscriber, Long discardsPurge, Long abandoned,
                                      String name);
}
