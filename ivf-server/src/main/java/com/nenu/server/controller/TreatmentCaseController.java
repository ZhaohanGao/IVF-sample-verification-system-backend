package com.nenu.server.controller;


import com.nenu.server.config.utils.AdminUtils;
import com.nenu.server.pojo.*;
import com.nenu.server.service.ICycleService;
import com.nenu.server.service.ITreatmentCaseService;
import io.swagger.annotations.ApiModelProperty;
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
@RequestMapping("/treatment/case")
public class TreatmentCaseController {

    @Autowired
    private ITreatmentCaseService treatmentCaseService;

    @ApiOperation(value = "获取所有就诊案例（分页）")
    @GetMapping("/")
    public RespPageBean getTreatmentCaseByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                         @RequestParam(defaultValue = "10") Integer size,
                                         TreatmentCase treatmentCase,
                                         LocalDate[] beginDateScope,
                                         LocalDate[] endDateScope){
        return treatmentCaseService.getTreatmentCaseByPage(currentPage,
                size,treatmentCase,beginDateScope,endDateScope);
    }

    @ApiOperation(value = "添加实验操作表项")
    @PostMapping("/")
    public RespBean addTreatmentCase(@RequestBody TreatmentCase treatmentCase){
        treatmentCase.setBeginDate(LocalDate.now());
        treatmentCase.setEndDate(LocalDate.now());
        if (treatmentCaseService.save(treatmentCase)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新就诊案例")
    @PutMapping("/")
    public RespBean updateTreatmentCase(@RequestBody TreatmentCase treatmentCase){
        treatmentCase.setBeginDate(LocalDate.now());
        if (treatmentCaseService.updateById(treatmentCase)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除就诊案例")
    @DeleteMapping("/{tcId}")
    public RespBean deleteTreatmentCase(@PathVariable Integer tcId){
        if (treatmentCaseService.removeById(tcId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除就诊案例")
    @DeleteMapping("/")
    public RespBean deleteTreatmentCase(Integer[] tcIds){
        if (treatmentCaseService.removeByIds(Arrays.asList(tcIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }




}
