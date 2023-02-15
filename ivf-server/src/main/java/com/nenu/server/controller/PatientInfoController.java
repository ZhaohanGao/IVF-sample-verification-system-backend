package com.nenu.server.controller;

import com.nenu.server.pojo.Admin;
import com.nenu.server.pojo.Menu;
import com.nenu.server.pojo.Patient;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.service.IAdminService;
import com.nenu.server.service.IPatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * @author Breon
 * @description: 患者个人信息查询
 * @date: 2023/1/15 17:53
 */

@RestController
@RequestMapping("/patient/info")
public class PatientInfoController {

    @Autowired
    private IPatientService patientService;
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "通过患者id查询患者信息")
    @GetMapping("/")
    public Patient getPatientInfoByAdminId(Principal principal){
        if (principal == null){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);

        return patientService.getById(admin.getId());
    }
}
