package com.hndx.repository;
import com.hndx.model.PbIcanteenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;
import java.util.List;
@Repository
public interface PbIcanteenRepository extends JpaRepository<PbIcanteenEntity, Integer> {
    public  List findByDepartIdEqualsAndOperationTypeEqualsAndMealTypeEqualsAndDealDateBetween(
            @Param("qDepartId")  Integer departId, @Param("qOperationType")  Integer operationType, @Param("qMealType")  Integer mealType,
            @Param("qBeginTime") Timestamp beginTime, @Param("qEndTime") Timestamp endTime);

    public List findBySysNoEqualsAndDealDateIsAfterOrderById(@Param("qSysNo")  Integer sysNO,@Param("qDealDate") Timestamp dealDate);
    //public List findBySysNoEquals(@Param("qSysNo")  Integer sysNO);
   // public List findByDepartIdEqualsAndDealDateLikeAndMealTypeEquals(@Param("qdeprtId") int departID,@Param("qcTime")Timestamp cTime, @Param("qMealType")  Integer mealType );
   @Query("select meIcan from PbIcanteenEntity meIcan  where meIcan.sysNo=:qSysNo")
   public Page<PbIcanteenEntity>  readBySysNoEquals(@Param("qSysNo") Integer sysNo, Pageable pageable);
   public List readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(
           @Param("qbTime")Timestamp qbTime,@Param("qeTime")Timestamp qeTime,@Param("qsysNo") Integer qsysNo,@Param("qmType") Integer qmType);



}
