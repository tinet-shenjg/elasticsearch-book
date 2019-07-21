package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.model.LoginModel;
import com.shenjg.book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseModel login(@RequestBody LoginModel loginModel) {

        String token = loginService.login(loginModel.getUsername(),
                loginModel.getPassword());

        return new ResponseModel(HttpStatus.OK, token);
    }

}
