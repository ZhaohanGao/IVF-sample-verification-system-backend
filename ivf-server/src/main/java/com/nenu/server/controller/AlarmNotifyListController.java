package com.nenu.server.controller;


import com.nenu.server.pojo.AlarmNotifyList;
import com.nenu.server.pojo.ExperimentOpt;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.service.IAlarmNotifyListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
@RequestMapping("/sys/cfg/alarm")
public class AlarmNotifyListController {

    @Autowired
    private IAlarmNotifyListService alarmNotifyListService;

    @ApiOperation(value = "获取所有报警通知人员列表")
    @GetMapping("/")
    public List<AlarmNotifyList> getAllExperimentOpts(){
        return alarmNotifyListService.list();
    }

    @ApiOperation(value = "添加报警通知人员表项")
    @PostMapping("/")
    public RespBean addAlarmNotifyList(@RequestBody AlarmNotifyList alarmNotifyList){
        if (alarmNotifyListService.save(alarmNotifyList)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新报警通知人员表项")
    @PutMapping("/")
    public RespBean updateAlarmNotifyList(@RequestBody AlarmNotifyList alarmNotifyList){
        if (alarmNotifyListService.updateById(alarmNotifyList)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除报警通知人员表项")
    @DeleteMapping("/{id}")
    public RespBean deleteAlarmNotifyList(@PathVariable Integer id){
        if (alarmNotifyListService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除报警通知人员表项")
    @DeleteMapping("/")
    public RespBean deleteAlarmNotifyListsByIds(Integer[] adminID){
        if (alarmNotifyListService.removeByIds(Arrays.asList(adminID))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
