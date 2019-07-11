package com.shenjg.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 首页
 *
 * @author shenjg
 * @date 2019/07/11
 **/
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "index");
        return "/index";
    }
}
