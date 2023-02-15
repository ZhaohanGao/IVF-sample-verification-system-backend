package com.nenu.server.controller;


import com.nenu.server.pojo.*;
import com.nenu.server.service.IWitLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/witness/log")
public class WitLogController {

    @Autowired
    private IWitLogService witLogService;

    @ApiOperation(value = "获取所有见证日志（分页）")
    @GetMapping("/")
    public RespPageBean getAllWitLogs(@RequestParam(defaultValue = "1") Integer currentPage,
                                      @RequestParam(defaultValue = "10") Integer size,
                                      WitLog witLog,
                                      LocalDateTime[] dateTimeScope,
                                      LocalDateTime[] rfid1RectimeScope,
                                      LocalDateTime[] rfid2RectimeScope){
        return witLogService.getWitLogByPage(currentPage,
                size,witLog,dateTimeScope,rfid1RectimeScope,rfid2RectimeScope);
    }

    @ApiOperation(value = "添加见证日志")
    @PostMapping("/")
    public RespBean addWitLog(@RequestBody WitLog witLog){
        if (witLogService.save(witLog)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新见证日志")
    @PutMapping("/")
    public RespBean updateWitLog(@RequestBody WitLog witLog){
        if (witLogService.updateById(witLog)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除见证日志")
    @DeleteMapping("/{logId}")
    public RespBean deleteWitLog(@PathVariable Integer logId){
        if (witLogService.removeById(logId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除见证日志")
    @DeleteMapping("/")
    public RespBean deleteWitLogsByIds(Integer[] logIds){
        if (witLogService.removeByIds(Arrays.asList(logIds))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
