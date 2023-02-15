package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.Patient;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface PatientMapper extends BaseMapper<Patient> {

    /**
     * 获取所有患者信息（分页）
     * @param page
     * @param patient
     * @param birthdayScope
     * @return
     */
    IPage<Patient> getPatientByPage(Page<Patient> page,
                                    @Param("patient")Patient patient,
                                    @Param("birthdayScope")LocalDate[] birthdayScope);
}
