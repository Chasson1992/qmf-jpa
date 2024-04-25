package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.VirtualHost;
import com.lmco.swfts.fishnet.qmf.model.VirtualHostId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualHostRepository extends JpaRepository<VirtualHost, VirtualHostId> {
}