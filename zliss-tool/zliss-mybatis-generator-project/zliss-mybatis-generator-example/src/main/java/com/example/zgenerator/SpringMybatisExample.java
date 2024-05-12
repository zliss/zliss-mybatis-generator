package com.example.zgenerator;

import com.example.zgenerator.test.project.entity.ZItemT;
import com.example.zgenerator.test.project.entity.ZUser;
import com.example.zgenerator.test.project.entity.sub.ZItem;
import com.example.zgenerator.test.project.repository.ZItemTRepository;
import com.example.zgenerator.test.project.repository.ZUserRepository;
import com.example.zgenerator.test.project.repository.sub.ZItemRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class SpringMybatisExample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ZUserRepository zUserRepository = ac.getBean(ZUserRepository.class);
        ZUser zUser = new ZUser();
        zUser.setName("test");
        zUserRepository.insert(zUser);
        List<ZUser> zUserList = zUserRepository.selectPage(new ZUser(), new PageRequest(0, 10));

        ZItemTRepository zItemTRepository = ac.getBean(ZItemTRepository.class);
        ZItemT zItemT = new ZItemT();
        zItemT.setType("test");
        zItemTRepository.insert(zItemT);
        List<ZItemT> zItemTList = zItemTRepository.selectPage(new ZItemT(), new PageRequest(0, 10));

        ZItemRepository zItemRepository = ac.getBean(ZItemRepository.class);
        ZItem zItem = new ZItem();
        zItem.setType("test");
        zItemRepository.insert(zItem);
        List<ZItem> zItemList = zItemRepository.selectPage(new ZItem(), new PageRequest(0, 10));
    }
}
