package com.hndx.repository;
import com.hndx.model.PbBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
public interface PbBalanceRepository extends JpaRepository<PbBalanceEntity,Integer>{
    // 定义查询
    // @Param注解用于提取参
    public List findBySysNoEquals(@Param("qSysNo") int sysNo);
}
