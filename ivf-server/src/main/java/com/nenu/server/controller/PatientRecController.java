package com.nenu.server.controller;

import com.nenu.server.pojo.Admin;
import com.nenu.server.pojo.Patient;
import com.nenu.server.pojo.TreatmentRec;
import com.nenu.server.service.IAdminService;
import com.nenu.server.service.IPatientService;
import com.nenu.server.service.ITreatmentRecService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * @author Breon
 * @description: TODO
 * @date: 2023/1/18 18:07
 */
@RestController
@RequestMapping("/patient/rec")
public class PatientRecController {

    @Autowired
    private ITreatmentRecService treatmentRecService;
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "通过患者id查询患者就诊记录")
    @GetMapping("/")
    public List<TreatmentRec> getPatientRecByAdminId(Principal principal){
        if (principal == null){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);

        return treatmentRecService.getTreatmentRecByAdminId(admin.getId());
    }
}
