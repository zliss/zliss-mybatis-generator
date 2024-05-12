package com.example.zgenerator.test.project.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.example.zgenerator.test.project.entity.ZUser;

@Repository
public interface ZUserRepository {

    ZUser selectByPrimaryKey(Long id);

    int insert(ZUser zUser);

    int updateByPrimaryKey(ZUser zUser);

    int deleteByPrimaryKey(ZUser zUser);

    int selectCount(@Param("zUser") ZUser zUser);

    List<ZUser> selectPage(@Param("zUser") ZUser zUser, @Param("pageable") Pageable pageable);

}