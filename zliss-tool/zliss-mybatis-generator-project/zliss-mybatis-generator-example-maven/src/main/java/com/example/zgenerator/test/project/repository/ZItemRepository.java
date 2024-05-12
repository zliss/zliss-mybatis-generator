package com.example.zgenerator.test.project.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.example.zgenerator.test.project.entity.ZItem;

@Repository
public interface ZItemRepository {

    ZItem selectByPrimaryKey(Long id);

    int insert(ZItem zItem);

    int updateByPrimaryKey(ZItem zItem);

    int deleteByPrimaryKey(ZItem zItem);

    int selectCount(@Param("zItem") ZItem zItem);

    List<ZItem> selectPage(@Param("zItem") ZItem zItem, @Param("pageable") Pageable pageable);

}