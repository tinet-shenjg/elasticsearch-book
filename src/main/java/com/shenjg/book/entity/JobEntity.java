package com.shenjg.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shenjg.book.model.JobModel;
import com.shenjg.book.utils.DataTimeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String projectName;

    private String areaCode;

    private LocalDateTime publishTime;

    private String publishUser;

    private Long phone;

    private String description;

    /**
     * 转为model
     *
     * @return JobModel
     */
    public JobModel toJobModel() {
        JobModel jobModel = JobModel
                .builder()
                .id(this.id)
                .areaCode(this.getAreaCode())
                .description(this.getDescription())
                .phone(this.phone)
                .time(DataTimeUtils.getDataTimeStr(this.publishTime))
                .publishTime(this.publishTime)
                .projectName(this.projectName)
                .publishUser(this.publishUser)
                .build();
        return jobModel;
    }
}
