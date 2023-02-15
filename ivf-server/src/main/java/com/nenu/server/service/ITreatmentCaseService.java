package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.TreatmentCase;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface ITreatmentCaseService extends IService<TreatmentCase> {


    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param size
     * @param treatmentCase
     * @param beginDateScope
     * @param endDateScope
     * @return
     */
    RespPageBean getTreatmentCaseByPage(Integer currentPage, Integer size,
                                        TreatmentCase treatmentCase,
                                        LocalDate[] beginDateScope,
                                        LocalDate[] endDateScope);
}
