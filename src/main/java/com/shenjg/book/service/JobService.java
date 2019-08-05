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
    List<JobEntity> list(LimitOffset limitOffset);
}
