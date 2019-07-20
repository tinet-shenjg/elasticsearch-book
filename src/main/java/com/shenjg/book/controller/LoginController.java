package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录相关控制器
 *
 * @author shenjg
 * @date 2019/07/20
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    public ResponseModel login(){
        return new ResponseModel(HttpStatus.OK);
    }

}
