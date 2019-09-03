package com.shenjg.book.model;

import com.shenjg.book.entity.AdminUser;
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
public class AdminUserModel {

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

    public AdminUser toAdminUser(){
        return AdminUser.builder()
                .id(id)
                .password(this.password)
                .username(this.username)
                .phone(this.phone)
                .email(this.email)
                .nickname(this.nickname)
                .organizationId(this.organizationId)
                .build();
    }
}
