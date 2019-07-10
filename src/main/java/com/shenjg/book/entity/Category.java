package com.shenjg.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 种类
 *
 * @author shenjg
 * @date 2019/07/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    /**
     * 种类Id
     */
    private Integer id;

    /**
     * 种类名称
     */
    private String name;
}
