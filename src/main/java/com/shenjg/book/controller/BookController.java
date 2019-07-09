package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书Controller
 *
 * @author shenjg
 * @date 2019/07/09
 */
@RestController
@RequestMapping("book")
public class BookController {

    @GetMapping
    public ResponseModel getBook(@RequestParam("keyword") String keyword) {
        //TODO 查询ES数据
        return new ResponseModel(HttpStatus.OK);
    }
}
