package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.TreatmentCaseMapper;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.TreatmentCase;
import com.nenu.server.service.ITreatmentCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@Service
public class TreatmentCaseServiceImpl extends ServiceImpl<TreatmentCaseMapper, TreatmentCase> implements ITreatmentCaseService {

    @Autowired
    private TreatmentCaseMapper treatmentCaseMapper;


    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param size
     * @param treatmentCase
     * @param beginDateScope
     * @param endDateScope
     * @return
     */
    @Override
    public RespPageBean getTreatmentCaseByPage(Integer currentPage, Integer size,
                                           TreatmentCase treatmentCase,
                                               LocalDate[] beginDateScope,
                                               LocalDate[] endDateScope) {
        //开启分页
        Page<TreatmentCase> page = new Page<>(currentPage, size);
        IPage<TreatmentCase> treatmentCaseByPage = treatmentCaseMapper.getTreatmentCaseByPage(page,treatmentCase,beginDateScope,endDateScope);
        RespPageBean respPageBean = new RespPageBean(treatmentCaseByPage.getTotal(),treatmentCaseByPage.getRecords());
        return respPageBean;
    }
}
