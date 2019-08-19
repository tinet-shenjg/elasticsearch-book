package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.entity.AdminUser;
import com.shenjg.book.model.AdminUserModel;
import com.shenjg.book.service.AdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "新增用户信息", notes = "不要乱用")
    @PostMapping
    public ResponseModel add(@RequestBody AdminUserModel adminUserModel){
        AdminUser adminUser = adminUserModel.toAdminUser();
        adminUserService.add(adminUser);
        adminUserModel.setId(adminUser.getId());
        return new ResponseModel(adminUserModel, HttpStatus.OK);
    }

    @ApiOperation(value = "删除用户信息", notes = "不要乱用")
    @DeleteMapping("/{id}")
    public ResponseModel delete(@PathVariable Integer id){
        adminUserService.delete(id);
        return new ResponseModel(id, HttpStatus.OK);
    }
}
