package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Session;
import com.lmco.swfts.fishnet.qmf.model.SessionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SessionRepository extends JpaRepository<Session, SessionId> {
    @Transactional
    @Modifying
    @Query("update Session s set s.txnCount = ?1, s.txnStarts = ?2, s.txnCommits = ?3, s.txnRejects = ?4, s.txnCount = ?5 where s.sessionId = ?2")
    void updateStatisticsBySessionId(Long unackedMessages, Long txnStarts, Long txnCommits, Long txnRejects, Long txnCount, SessionId sessionId);
}