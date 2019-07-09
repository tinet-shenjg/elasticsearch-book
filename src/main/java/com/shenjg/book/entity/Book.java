package com.shenjg.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book
 *
 * @author shenjg
 * @date 2019/07/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    /**
     * 图书Id
     */
    private Integer id;

    /**
     * 种类Id
     */
    private Integer catagoryId;

    /**
     * 内容
     */
    private String content;

    /**
     * 图书地址
     */
    private String url;
}
