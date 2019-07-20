package com.shenjg.book.service;

/**
 * 登录service
 *
 * @author shenjg
 * @date 2019/07/20
 **/
public interface LoginService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);
}

