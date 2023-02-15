package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.Admin;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.TreatmentRec;

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
public interface ITreatmentRecService extends IService<TreatmentRec> {


    /**
     * 获取所有就诊记录（分页）
     * @param currentPage
     * @param size
     * @param treatmentRec
     * @param trDateScope
     * @param feeScope1
     * @param feeScope2
     * @return
     */
    RespPageBean getTreatmentRecByPage(Integer currentPage, Integer size, TreatmentRec treatmentRec, LocalDateTime[] trDateScope, Double feeScope1, Double feeScope2);

    /**
     * 根据操作员id获取就诊记录
     * @param id
     * @return
     */
    List<TreatmentRec> getTreatmentRecByAdminId(Integer id);
}
