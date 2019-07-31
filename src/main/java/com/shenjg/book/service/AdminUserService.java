package com.shenjg.book.service;

import com.shenjg.book.entity.AdminUser;

import java.util.List;

/**
 * AdminUserService
 *
 * @author shenjg
 * @date 2019/07/31
 */
public interface AdminUserService {

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<AdminUser> list();
}
