package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.TreatmentCase;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface TreatmentCaseMapper extends BaseMapper<TreatmentCase> {

    /**
     * 获取所有员工（分页）
     * @param page
     * @param treatmentCase
     * @return
     */
    IPage<TreatmentCase> getTreatmentCaseByPage(Page<TreatmentCase> page,
                                                @Param("treatmentCase") TreatmentCase treatmentCase,
                                                @Param("beginDateScope") LocalDate[] beginDateScope,
                                                @Param("endDateScope") LocalDate[] endDateScope);
}
