package com.nenu.server.controller;


import com.nenu.server.config.utils.AdminUtils;
import com.nenu.server.pojo.ExperimentOpt;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.service.IAdminService;
import com.nenu.server.service.IExperimentOptService;
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
@RequestMapping("/experiment/opt")
public class ExperimentOptController {

    @Autowired
    private IExperimentOptService experimentOptService;

    @ApiOperation(value = "获取所有实验操作表项（分页）")
    @GetMapping("/")
    public RespPageBean getExperimentOptByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                           @RequestParam(defaultValue = "10") Integer size,
                                           ExperimentOpt experimentOpt,
                                           LocalDateTime[] expDateScope){
        return experimentOptService.getExperimentOptByPage(currentPage,
                size,experimentOpt,expDateScope);
    }

    @ApiOperation(value = "添加实验操作表项")
    @PostMapping("/")
    public RespBean addExperimentOpt(@RequestBody ExperimentOpt experimentOpt){
        //添加操作员id
        experimentOpt.setOperatorId(AdminUtils.getCurrentAdmin().getId());

        if (experimentOptService.save(experimentOpt)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新实验操作表项")
    @PutMapping("/")
    public RespBean updateExperimentOpt(@RequestBody ExperimentOpt experimentOpt){
        if (experimentOptService.updateById(experimentOpt)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除实验操作表项")
    @DeleteMapping("/{expId}")
    public RespBean deleteExperimentOpt(@PathVariable Integer expId){
        if (experimentOptService.removeById(expId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除实验操作表项")
    @DeleteMapping("/")
    public RespBean deleteExperimentOptByIds(Integer[] expIds){
        if (experimentOptService.removeByIds(Arrays.asList(expIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
