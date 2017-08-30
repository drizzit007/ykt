package com.hndx.repository;

import com.hndx.model.DxRecordEntity;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface DxRecordRepository extends JpaRepository<DxRecordEntity,Integer> {
    // 定义查询
    // @Param注解用于提取参
    public List readFirstByClDdidEquals(@Param("qClDD") int clDD);
    public List readAllByDeptIdEquals(@Param("dptId") int dptId);
    @Query("select dxRcd from DxRecordEntity dxRcd  where dxRcd.deptId=:qdeptId")
    public Page<DxRecordEntity>  readByDeptIdEquals(@Param("qdeptId") Integer qdeptId, Pageable pageable);


}
