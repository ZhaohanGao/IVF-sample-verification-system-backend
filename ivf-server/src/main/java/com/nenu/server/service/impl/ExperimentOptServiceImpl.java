package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.ExperimentOptMapper;
import com.nenu.server.pojo.ExperimentOpt;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleSperm;
import com.nenu.server.service.IExperimentOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@Service
public class ExperimentOptServiceImpl extends ServiceImpl<ExperimentOptMapper, ExperimentOpt> implements IExperimentOptService {

    @Autowired
    private ExperimentOptMapper experimentOptMapper;
    /**
     * 获取所有实验操作表项（分页）
     * @param currentPage
     * @param size
     * @param experimentOpt
     * @param expDateScope
     * @return
     */
    @Override
    public RespPageBean getExperimentOptByPage(Integer currentPage, Integer size, ExperimentOpt experimentOpt, LocalDateTime[] expDateScope) {
        //开启分页
        Page<SampleSperm> page = new Page<>(currentPage, size);
        IPage<SampleSperm> experimentOptByPage = experimentOptMapper.getExperimentOptByPage(page,experimentOpt,expDateScope);
        RespPageBean respPageBean = new RespPageBean(experimentOptByPage.getTotal(),experimentOptByPage.getRecords());
        return respPageBean;
    }
}
