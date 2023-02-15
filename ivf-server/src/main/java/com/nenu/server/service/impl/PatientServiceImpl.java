package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.PatientMapper;
import com.nenu.server.mapper.SampleEggMapper;
import com.nenu.server.pojo.Patient;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.service.IPatientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

    @Autowired
    private PatientMapper patientMapper;
    /**
     * 获取所有患者信息（分页）
     * @param currentPage
     * @param size
     * @param patient
     * @param birthdayScope
     * @return
     */
    @Override
    public RespPageBean getPatientByPage(Integer currentPage, Integer size, Patient patient, LocalDate[] birthdayScope) {
        //开启分页
        Page<Patient> page = new Page<>(currentPage, size);
        IPage<Patient> patientByPage = patientMapper.getPatientByPage(page,patient,birthdayScope);
        RespPageBean respPageBean = new RespPageBean(patientByPage.getTotal(),patientByPage.getRecords());
        return respPageBean;
    }
}
