package com.example.zgenerator.test.project.repository.sub;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.example.zgenerator.test.project.entity.sub.ZItem;

@Repository
public interface ZItemRepository {

    int insert(ZItem zItem);

    List<ZItem> selectPage(@Param("zItem") ZItem zItem, @Param("pageable") Pageable pageable);

}