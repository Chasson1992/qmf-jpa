package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    @Transactional
    @Modifying
    @Query("update Subscription s set s.delivered = ?1 where s.name = ?2")
    void updateDeliveredByName(Long delivered, String name);
}