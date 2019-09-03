package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器
 *
 * @author shenjg
 * @date 2019/08/18
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @PostMapping
    public ResponseModel add(){
        //TODO
       return new ResponseModel(HttpStatus.OK);
    }
}
