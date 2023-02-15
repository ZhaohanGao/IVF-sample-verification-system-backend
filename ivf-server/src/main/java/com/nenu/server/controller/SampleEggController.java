package com.nenu.server.controller;


import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.pojo.SampleSperm;
import com.nenu.server.service.ISampleEggService;
import com.nenu.server.service.ISampleSpermService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/info/egg")
public class SampleEggController {

    @Autowired
    private ISampleEggService sampleEggService;

    @ApiOperation(value = "获取所有女性细胞信息（分页）")
    @GetMapping("/")
    public RespPageBean getSampleEggByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "10") Integer size,
                                             SampleEgg sampleEgg,
                                             LocalDateTime[] collectDateScope){
        return sampleEggService.getSampleEggByPage(currentPage,
                size,sampleEgg,collectDateScope);
    }

    @ApiOperation(value = "添加女性细胞信息")
    @PostMapping("/")
    public RespBean addSampleEgg(@RequestBody SampleEgg sampleEgg){
        if (sampleEggService.save(sampleEgg)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新女性细胞信息")
    @PutMapping("/")
    public RespBean updateSampleEgg(@RequestBody SampleEgg sampleEgg){
        if (sampleEggService.updateById(sampleEgg)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除女性细胞信息")
    @DeleteMapping("/{seId}")
    public RespBean deleteSampleEgg(@PathVariable Integer seId){
        if (sampleEggService.removeById(seId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除女性细胞信息")
    @DeleteMapping("/")
    public RespBean deleteSampleEgg(Integer[] seIds){
        if (sampleEggService.removeByIds(Arrays.asList(seIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
