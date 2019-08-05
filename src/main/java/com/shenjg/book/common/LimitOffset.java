package com.shenjg.book.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页工具
 *
 * @author shenjg
 * @date 2019/08/05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitOffset {
    private Integer limit;

    private Integer offset;
}
