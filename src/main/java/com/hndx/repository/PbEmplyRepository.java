package com.hndx.repository;
import com.hndx.model.PbEmplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface PbEmplyRepository  extends JpaRepository<PbEmplyEntity, Integer>  {
      public List findByPhoneEquals(@Param("qPhone") String phone);
      public Integer countPbEmplyEntitiesByDepartIdEqualsAndIsDeleteEquals(@Param("qdptid") Integer departID,@Param("qisDeletce") Integer isDelete);
      public List readByDepartIdEqualsAndIsDeleteEquals(@Param("qdptid") Integer departID,@Param("qisDeletce") Integer isDelete);
}
