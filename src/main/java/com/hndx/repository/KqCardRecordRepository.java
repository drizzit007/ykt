package com.hndx.repository;

import com.hndx.model.KqCardRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface KqCardRecordRepository extends JpaRepository<KqCardRecordEntity,Integer>{
    //public List findByCardTimeLikeAndDeptIdEquals(@Param("qcTime")Timestamp cTime,@Param("qdeprtId") int departID);
    public List readFirstByCardTimeBetweenAndSysNoEquals(@Param("qbTime")Timestamp qbTime,@Param("qeTime")Timestamp qeTime,@Param("qsysNo") Integer qsysNo);

}
