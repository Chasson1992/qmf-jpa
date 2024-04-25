package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Connection;
import com.lmco.swfts.fishnet.qmf.model.ConnectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ConnectionRepository extends JpaRepository<Connection, ConnectionId> {
    @Transactional
    @Modifying
    @Query("update Connection c set c.framesFromClient = :framesFromClient, c.framesToClient = :framesToClient, c.bytesFromClient = :bytesFromClient, c.bytesToClient = :bytesToClient, c.msgsFromClient = :msgsFromClient, c.msgsToClient = :msgsToClient where c.connectionId = :connectionId")
    void updateStatisticsByConnectionId(Long framesFromClient, Long framesToClient, Long bytesFromClient, Long bytesToClient, Long msgsFromClient, Long msgsToClient, ConnectionId connectionId);
}