package com.nenu.server.controller;


import com.nenu.server.pojo.*;
import com.nenu.server.service.ITreatmentRecService;
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
@RequestMapping("/treatment/rec")
public class TreatmentRecController {

    @Autowired
    private ITreatmentRecService treatmentRecService;

    @ApiOperation(value = "获取所有就诊记录（分页）")
    @GetMapping("/")
    public RespPageBean getTreatmentRecByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                           @RequestParam(defaultValue = "10") Integer size,
                                              TreatmentRec treatmentRec,
                                           LocalDateTime[] trDateScope,
                                              Double feeScope1,
                                              Double feeScope2){
        return treatmentRecService.getTreatmentRecByPage(currentPage,
                size,treatmentRec,trDateScope,feeScope1,feeScope2);
    }

    @ApiOperation(value = "添加就诊记录")
    @PostMapping("/")
    public RespBean addTreatmentRec(@RequestBody TreatmentRec treatmentRec){
        if (treatmentRecService.save(treatmentRec)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新就诊记录")
    @PutMapping("/")
    public RespBean updateTreatmentRec(@RequestBody TreatmentRec treatmentRec){
        if (treatmentRecService.updateById(treatmentRec)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除就诊记录")
    @DeleteMapping("/{trId}")
    public RespBean deleteTreatmentRec(@PathVariable Integer trId){
        if (treatmentRecService.removeById(trId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除就诊记录")
    @DeleteMapping("/")
    public RespBean deleteTreatmentRecsByIds(Integer[] trIds){
        if (treatmentRecService.removeByIds(Arrays.asList(trIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
