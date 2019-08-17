package com.shenjg.book.service.impl;

import com.shenjg.book.entity.AdminUser;
import com.shenjg.book.mapper.AdminUserMapper;
import com.shenjg.book.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdminUserServiceImpl
 *
 * @author shenjg
 * @date 2019/07/31
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;
    @Override
    public List<AdminUser> list() {
        return adminUserMapper.selectList(null);
    }

    @Override
    public Integer add(AdminUser adminUser) {
        return adminUserMapper.insert(adminUser);
    }
}
