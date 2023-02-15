package com.nenu.server.controller;


import com.nenu.server.pojo.Cycle;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.TreatmentCase;
import com.nenu.server.service.ICycleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
@RequestMapping("/info/cycle")
public class CycleController {

    @Autowired
    private ICycleService cycleService;

    @ApiOperation(value = "获取所有周期（分页）")
    @GetMapping("/")
    public RespPageBean getCycleByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                       @RequestParam(defaultValue = "10") Integer size,
                                       Cycle cycle){
        return cycleService.getCycleByPage(currentPage,size,cycle);
    }

    @ApiOperation(value = "添加周期")
    @PostMapping("/")
    public RespBean addCycle(@RequestBody Cycle cycle){
        if (cycleService.save(cycle)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新周期")
    @PutMapping("/")
    public RespBean updateCycle(@RequestBody Cycle cycle){
        if (cycleService.updateById(cycle)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除周期")
    @DeleteMapping("/{cId}")
    public RespBean deleteTreatmentCase(@PathVariable Integer ccId){
        if (cycleService.removeById(ccId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除周期")
    @DeleteMapping("/")
    public RespBean deleteTreatmentCase(Integer[] ccIds){
        if (cycleService.removeByIds(Arrays.asList(ccIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
