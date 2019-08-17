package com.shenjg.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author shenjg
 * @date 2019/07/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUser {

    private Integer id;

    private String username;

    private String password;
    /**
     * 手机号
     */
    private Long phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 组织id
     */
    private Integer organizationId;
}
