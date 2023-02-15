package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.Patient;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.RespPageBean;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface IPatientService extends IService<Patient> {

    /**
     * 获取所有患者信息（分页）
     * @param currentPage
     * @param size
     * @param patient
     * @param birthdayScope
     * @return
     */
    RespPageBean getPatientByPage(Integer currentPage, Integer size, Patient patient, LocalDate[] birthdayScope);


}
