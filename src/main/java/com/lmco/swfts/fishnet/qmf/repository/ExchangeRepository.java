package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Exchange;
import com.lmco.swfts.fishnet.qmf.model.ExchangeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ExchangeRepository extends JpaRepository<Exchange, ExchangeId> {
    @Transactional
    @Modifying
    @Query("update Exchange e set e.msgReceives = :msgReceives, e.msgDrops = :msgDrops, e.msgRoutes = :msgRoutes, e.byteReceives = :byteReceives, e.byteDrops = :byteDrops, e.byteRoutes = :byteRoutes, e.bindingCount = :bindingCount where e.exchangeId = :exchangeId")
    void updateStatisticsByExchangeId(Long msgReceives, Long msgDrops, Long msgRoutes, Long byteReceives, Long byteDrops, Long byteRoutes, Long bindingCount, ExchangeId exchangeId);
}