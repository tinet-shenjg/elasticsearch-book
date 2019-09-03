package com.shenjg.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenjg.book.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * JobMapper
 *
 * @author shenjg
 * @date 2019/08/05
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
}
