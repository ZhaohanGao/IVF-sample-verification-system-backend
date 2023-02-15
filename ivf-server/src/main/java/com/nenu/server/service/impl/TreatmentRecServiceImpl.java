package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.TreatmentRecMapper;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.pojo.TreatmentRec;
import com.nenu.server.service.ITreatmentRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TreatmentRecServiceImpl extends ServiceImpl<TreatmentRecMapper, TreatmentRec> implements ITreatmentRecService {

    @Autowired
    private TreatmentRecMapper treatmentRecMapper;

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
    @Override
    public RespPageBean getTreatmentRecByPage(Integer currentPage, Integer size, TreatmentRec treatmentRec, LocalDateTime[] trDateScope, Double feeScope1, Double feeScope2) {
        //开启分页
        Page<TreatmentRec> page = new Page<>(currentPage, size);
        IPage<TreatmentRec> treatmentRecByPage = treatmentRecMapper.getTreatmentRecByPage(page,treatmentRec,trDateScope, feeScope1, feeScope2);
        RespPageBean respPageBean = new RespPageBean(treatmentRecByPage.getTotal(),treatmentRecByPage.getRecords());
        return respPageBean;
    }

    /**
     * 根据操作员id获取就诊记录
     * @param id
     * @return
     */
    @Override
    public List<TreatmentRec> getTreatmentRecByAdminId(Integer id) {
        return treatmentRecMapper.getTreatmentRecByAdminId(id);
    }
}
