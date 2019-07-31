package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.entity.AdminUser;
import com.shenjg.book.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户相关控制器
 *
 * @author shenjg
 * @date 2019/07/20
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/list")
    public ResponseModel list(){
        List<AdminUser> adminUsers = adminUserService.list();
        return new ResponseModel(HttpStatus.OK);

    }
}
