package com.shenjg.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
public class JobModel {
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
