package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 图书Controller
 *
 * @author shenjg
 * @date 2019/07/09
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseModel getBook(String keyword) {

        String[] fieldNames = {"content","name"};
        List<Map<String, Object>> list = bookService
                .searchDocs("books", keyword, fieldNames,1,10);
        //TODO 查询ES数据
        return new ResponseModel(list,HttpStatus.OK);
    }
}
