package com.shenjg.book.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 登录模型
 *
 * @author shenjg
 * @date 2019/07/21
 **/
@Data
public class LoginModel {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
