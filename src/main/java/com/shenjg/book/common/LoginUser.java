package com.shenjg.book.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户
 *
 * @author shenjg
 * @date 2019/07/20
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录用户ID
     */
    private String id;
}
