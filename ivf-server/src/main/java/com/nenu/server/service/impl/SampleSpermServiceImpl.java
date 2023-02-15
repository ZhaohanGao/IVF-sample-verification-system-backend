package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.SampleSpermMapper;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleSperm;
import com.nenu.server.pojo.TreatmentCase;
import com.nenu.server.service.ISampleSpermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
public class SampleSpermServiceImpl extends ServiceImpl<SampleSpermMapper, SampleSperm> implements ISampleSpermService {

    @Autowired
    private SampleSpermMapper sampleSpermMapper;
    /**
     * 获取所有男性细胞信息（分页）
     * @param currentPage
     * @param size
     * @param sampleSperm
     * @param collectDateScope
     * @return
     */
    @Override
    public RespPageBean getSampleSpermByPage(Integer currentPage, Integer size, SampleSperm sampleSperm, LocalDateTime[] collectDateScope) {
        //开启分页
        Page<SampleSperm> page = new Page<>(currentPage, size);
        IPage<SampleSperm> sampleSpermByPage = sampleSpermMapper.getSampleSpermByPage(page,sampleSperm,collectDateScope);
        RespPageBean respPageBean = new RespPageBean(sampleSpermByPage.getTotal(),sampleSpermByPage.getRecords());
        return respPageBean;
    }
}
