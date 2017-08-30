package com.hndx.repository;

import com.hndx.model.PbDepartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
public interface PbDepartRepository extends JpaRepository<PbDepartEntity, Integer> {
        // 定义查询
        // @Param注解用于提取参数
        public List findByStatusEqualsAndParentIdEquals(@Param("qStatus") Integer status,@Param("qParentId")  Integer parentId);
        public List readByStatusEqualsAndDepartIdEquals(@Param("qStatus") Integer status,@Param("qDptId")  int qDptId);
        public List readByParentIdEquals(@Param("qParentId")  Integer parentId);

}
