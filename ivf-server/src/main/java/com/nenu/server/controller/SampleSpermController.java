package com.nenu.server.controller;


import com.nenu.server.pojo.*;
import com.nenu.server.service.ISampleSpermService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/info/sperm")
public class SampleSpermController {

    @Autowired
    private ISampleSpermService sampleSpermService;

    @ApiOperation(value = "获取所有男性细胞信息（分页）")
    @GetMapping("/")
    public RespPageBean getSampleSpermByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                         @RequestParam(defaultValue = "10") Integer size,
                                         SampleSperm sampleSperm,
                                         LocalDateTime[] collectDateScope){
        return sampleSpermService.getSampleSpermByPage(currentPage,
                size,sampleSperm,collectDateScope);
    }

    @ApiOperation(value = "添加男性细胞信息")
    @PostMapping("/")
    public RespBean addSampleSperm(@RequestBody SampleSperm sampleSperm){
        if (sampleSpermService.save(sampleSperm)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新男性细胞信息")
    @PutMapping("/")
    public RespBean updateSampleSperm(@RequestBody SampleSperm sampleSperm){
        if (sampleSpermService.updateById(sampleSperm)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除男性细胞信息")
    @DeleteMapping("/{ssId}")
    public RespBean deleteSampleSperm(@PathVariable Integer ssId){
        if (sampleSpermService.removeById(ssId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除男性细胞信息")
    @DeleteMapping("/")
    public RespBean deleteSampleSperm(Integer[] ssIds){
        if (sampleSpermService.removeByIds(Arrays.asList(ssIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
