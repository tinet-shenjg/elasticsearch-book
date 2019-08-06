package com.shenjg.book.model;

import com.shenjg.book.entity.JobEntity;
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
public class JobModel {
    /**
     * 主键id
     */
    private Integer id;

    private String projectName;

    private String areaCode;

    private Date publishTime;

    private String publishUser;

    private Long phone;

    private String description;

    /**
     * 转为数据库实体类
     *
     * @return JobEntity
     */
    public JobEntity toJobEntity() {
        JobEntity jobEntity = JobEntity
                .builder()
                .id(this.id)
                .areaCode(this.getAreaCode())
                .description(this.getDescription())
                .phone(this.phone)
                .publishTime(this.publishTime)
                .projectName(this.projectName)
                .publishUser(this.publishUser)
                .build();
        return jobEntity;
    }


}
