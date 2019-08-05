package com.shenjg.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenjg.book.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * JobMapper
 *
 * @author shenjg
 * @date 2019/08/05
 */
@Mapper
public interface JobMapper extends BaseMapper<JobEntity> {
}
