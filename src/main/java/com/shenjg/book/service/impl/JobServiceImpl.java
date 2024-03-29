package com.shenjg.book.service.impl;

import com.shenjg.book.common.LimitOffset;
import com.shenjg.book.entity.JobEntity;
import com.shenjg.book.mapper.JobMapper;
import com.shenjg.book.model.JobModel;
import com.shenjg.book.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * JobServiceImpl
 *
 * @author shenjg
 * @date 2019/08/05
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobEntity> list(LimitOffset limitOffset) {
        return jobMapper.selectList(null);
    }

    @Override
    public Integer add(JobEntity jobEntity) {
        LocalDateTime localDateTime = LocalDateTime.now();
        jobEntity.setPublishTime(localDateTime);
        return jobMapper.insert(jobEntity);
    }

    @Override
    public Integer delete(Integer id) {
        return jobMapper.deleteById(id);
    }

    @Override
    public Integer update(JobEntity jobEntity) {
        return jobMapper.update(jobEntity,null);
    }

    @Override
    public JobModel get(Integer id) {
        JobEntity jobEntity = jobMapper.selectById(id);
        return jobEntity.toJobModel();
    }
}
