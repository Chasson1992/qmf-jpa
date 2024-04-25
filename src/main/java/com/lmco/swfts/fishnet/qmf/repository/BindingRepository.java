package com.lmco.swfts.fishnet.qmf.repository;

import com.lmco.swfts.fishnet.qmf.model.Binding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BindingRepository extends JpaRepository<Binding, String> {
    @Transactional
    @Modifying
    @Query("update Binding b set b.msgMatched = :msgMatched where b.bindingKey = :bindingKey")
    int updateMsgMatchedByBindingKey(Long msgMatched, String bindingKey);
}