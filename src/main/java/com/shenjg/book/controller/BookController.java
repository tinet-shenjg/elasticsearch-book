package com.shenjg.book.controller;

import com.shenjg.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 图书Controller
 *
 * @author shenjg
 * @date 2019/07/09
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public String getBook(Model model,String keyword) {

        // 构建查询字段
        String[] fieldNames = {"content","name"};
        //TODO 查询ES数据
        List<Map<String, Object>> list = bookService
                .searchDocs("books", keyword, fieldNames,1,10);
        model.addAttribute("list", list);
        return "main";
    }
}
