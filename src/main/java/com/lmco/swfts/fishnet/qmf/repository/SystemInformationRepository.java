package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.SystemInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SystemInformationRepository
    extends JpaRepository<SystemInformation, UUID> {
}
