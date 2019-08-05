package com.shenjg.book.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * JobModel
 *
 * @author shenjg
 * @date 2019/08/05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("job")
public class JobEntity {
    /**
     * 主键id
     */
    private Integer id;

    private String projectName;

    private Integer areaCode;

    private Date publishTime;

    private String publishUser;

    private Integer phone;

    private String description;


}
