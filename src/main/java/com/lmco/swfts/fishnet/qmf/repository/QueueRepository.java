package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Queue;
import com.lmco.swfts.fishnet.qmf.model.QueueId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface QueueRepository extends JpaRepository<Queue, QueueId> {
    @Transactional
    @Modifying
    @Query("update Queue q set q.consumerCount = :consumerCount, q.bindingCount = :bindingCount " +
            ", q.msgDepth = :msgDepth, q.byteDepth = :byteDepth, q.byteTotalEnqueues = :byteTotalEnqueues" +
            ", q.byteTotalDequeues = :byteTotalDequeues, q.msgTotalEnqueues = :msgTotalEnqueues, q.msgTotalDequeues = :msgTotalDequeues where q.queueId = :queueId")
    int updateStatisticsByQueueId(int consumerCount, int bindingCount, int msgDepth,
                               int byteDepth, int byteTotalEnqueues, int byteTotalDequeues,
                               int msgTotalEnqueues, int msgTotalDequeues, QueueId queueId);
}