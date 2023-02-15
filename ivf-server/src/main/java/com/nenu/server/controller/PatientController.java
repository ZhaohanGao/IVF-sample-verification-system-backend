package com.nenu.server.controller;


import com.nenu.server.pojo.*;
import com.nenu.server.service.IAdminService;
import com.nenu.server.service.IPatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/info/patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "获取所有患者信息（分页）")
    @GetMapping("/")
    public RespPageBean getPatientByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        Patient patient,
                                         LocalDate[] birthdayScope) {
        return patientService.getPatientByPage(currentPage,size,patient,birthdayScope);
    }

    @ApiOperation(value = "添加患者信息并注册为操作员")
    @PostMapping("/")
    public RespBean addPatient(@RequestBody Patient patient) {
        if (patientService.save(patient)) {
            adminService.initPatientAdminAccount(patient.getPtId(), patient.getName(), patient.getCitizenId());
            adminService.setNewAdminPassword(patient.getCitizenId().substring(patient.getCitizenId().length() - 6), patient.getPtId());
            adminService.setNewAdminRole(patient.getPtId());
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新患者信息")
    @PutMapping("/")
    public RespBean updatePatient(@RequestBody Patient patient) {
        if (patientService.updateById(patient)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除患者信息")
    @DeleteMapping("/{ptId}")
    public RespBean deletePatient(@PathVariable Integer ptId) {
        if (patientService.removeById(ptId) && adminService.removeById(ptId)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除患者信息")
    @DeleteMapping("/")
    public RespBean deletePatientsByIds(Integer[] ptIds) {
        if (patientService.removeByIds(Arrays.asList(ptIds)) && adminService.removeByIds(Arrays.asList(ptIds))) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
