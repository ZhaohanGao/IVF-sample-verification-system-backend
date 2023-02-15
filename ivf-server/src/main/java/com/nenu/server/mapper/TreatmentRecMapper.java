package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.TreatmentRec;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface TreatmentRecMapper extends BaseMapper<TreatmentRec> {


    /**
     * 获取所有就诊记录（分页）
     * @param page
     * @param treatmentRec
     * @param trDateScope
     * @param feeScope1
     * @param feeScope2
     * @return
     */
    IPage<TreatmentRec> getTreatmentRecByPage(Page<TreatmentRec> page, TreatmentRec treatmentRec, LocalDateTime[] trDateScope, Double feeScope1, Double feeScope2);

    /**
     * 根据操作员id获取就诊记录
     * @param id
     * @return
     */
    List<TreatmentRec> getTreatmentRecByAdminId(Integer id);
}
