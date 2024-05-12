package com.example.zgenerator.test.project.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.example.zgenerator.test.project.entity.ZItemT;

@Repository
public interface ZItemTRepository {

    ZItemT selectByPrimaryKey(Long id);

    int insert(ZItemT zItemT);

    int updateByPrimaryKey(ZItemT zItemT);

    int deleteByPrimaryKey(ZItemT zItemT);

    int selectCount(@Param("zItemT") ZItemT zItemT);

    List<ZItemT> selectPage(@Param("zItemT") ZItemT zItemT, @Param("pageable") Pageable pageable);

}