package com.shenjg.book.controller;

import com.shenjg.book.common.LimitOffset;
import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.entity.JobEntity;
import com.shenjg.book.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * JobInfoController
 *
 * @author shenjg
 * @date 2019/08/05
 */
@RestController
@RequestMapping("/job")
public class JobInfoController {

    @Autowired
    private JobService jobService;

    /**
     * 分页获取job信息
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseModel list(LimitOffset limitOffset) {
        List<JobEntity> jobEntityList = jobService.list(limitOffset);
        return new ResponseModel(jobEntityList, HttpStatus.OK);
    }
}
