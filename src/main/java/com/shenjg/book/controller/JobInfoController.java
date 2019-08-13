package com.shenjg.book.controller;

import com.shenjg.book.common.LimitOffset;
import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.entity.JobEntity;
import com.shenjg.book.model.JobModel;
import com.shenjg.book.service.JobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "分页获取job信息", notes = "不要乱用")
    @GetMapping("/list")
    public ResponseModel list(LimitOffset limitOffset) {
        List<JobEntity> jobEntityList = jobService.list(limitOffset);
        return new ResponseModel(jobEntityList, HttpStatus.OK);
    }

    /**
     * 新增job信息
     *
     * @param jobModel
     * @return
     */
    @ApiOperation(value = "新增job信息", notes = "不要乱用")
    @PostMapping()
    public ResponseModel add(@RequestBody JobModel jobModel) {
        JobEntity jobEntity = jobModel.toJobEntity();
        Integer id = jobService.add(jobEntity);
        jobModel.setId(id);
        return new ResponseModel(jobModel, HttpStatus.OK);
    }

    @ApiOperation(value = "修改job信息", notes = "不要乱用")
    @PutMapping()
    public ResponseModel update(@RequestBody JobModel jobModel) {
        JobEntity jobEntity = jobModel.toJobEntity();
        Integer id = jobService.update(jobEntity);
        return new ResponseModel(jobModel, HttpStatus.OK);
    }

    @ApiOperation(value = "根据id删除job信息", notes = "不要乱用")
    @DeleteMapping("/{id}")
    public ResponseModel delete(Integer id) {
        Integer deleteId = jobService.delete(id);
        return new ResponseModel(deleteId, HttpStatus.OK);
    }
}
