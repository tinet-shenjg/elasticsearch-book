package com.shenjg.book.service;

import com.shenjg.book.common.LimitOffset;
import com.shenjg.book.entity.JobEntity;

import java.util.List;

/**
 * JobService
 *
 * @author shenjg
 * @date 2019/08/05
 */
public interface JobService {
    /**
     * 查询工作信息
     *
     * @param limitOffset
     * @return
     */
    List<JobEntity> list(LimitOffset limitOffset);

    /**
     * 新增工作信息
     *
     * @param jobEntity
     * @return
     */
    Integer add(JobEntity jobEntity);
}