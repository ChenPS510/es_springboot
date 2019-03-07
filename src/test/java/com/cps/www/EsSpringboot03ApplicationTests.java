package com.cps.www;

import com.cps.www.dao.PoetryDao;
import com.cps.www.entity.Poetry;
import com.cps.www.es.CustomPoetryResposity;
import com.cps.www.es.PoetryRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsSpringboot03ApplicationTests {
    @Autowired
    private PoetryDao poetryDao;
    @Autowired
    private PoetryRespository poetryRespository;
    @Autowired
    private CustomPoetryResposity customPoetryResposity;

    @Test
    public void contextLoads() {
        List<Poetry> list = poetryDao.findALL();
        //list.forEach(v-> System.out.println(v));
        System.out.println(list.size());
        poetryRespository.saveAll(list);
    }

    @Test
    public void test01() {
        Optional<Poetry> id = poetryRespository.findById("1");
        System.out.println(id);
    }

    @Test
    public void test02() {
        List<Poetry> list = customPoetryResposity.finfPetryByTitleOrContent("鹅鹅鹅");
        list.forEach(v -> System.out.println(v));
    }
}
