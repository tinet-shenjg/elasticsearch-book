package com.shenjg.book;

import com.shenjg.book.entity.JobEntity;
import com.shenjg.book.mapper.JobMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * SampleTest
 *
 * @author shenjg
 * @date 2019/08/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private JobMapper jobMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<JobEntity> jobEntities = jobMapper.selectList(null);
        ;
        jobEntities.forEach(System.out::println);
    }

}
