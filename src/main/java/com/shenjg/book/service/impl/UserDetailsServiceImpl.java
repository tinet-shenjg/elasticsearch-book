package com.shenjg.book.service.impl;

import com.shenjg.book.common.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author shenjg
 * @date 2019/07/21
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser loginUser = LoginUser.builder()
                .id("33333")
                .username("admin").build();

        return loginUser;
    }
}
