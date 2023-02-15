package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.SampleEggMapper;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.pojo.SampleSperm;
import com.nenu.server.service.ISampleEggService;
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
public class SampleEggServiceImpl extends ServiceImpl<SampleEggMapper, SampleEgg> implements ISampleEggService {

    @Autowired
    private SampleEggMapper sampleEggMapper;

    /**
     * 获取所有女性细胞信息（分页）
     * @param currentPage
     * @param size
     * @param sampleEgg
     * @param collectDateScope
     * @return
     */
    @Override
    public RespPageBean getSampleEggByPage(Integer currentPage, Integer size, SampleEgg sampleEgg, LocalDateTime[] collectDateScope) {
        //开启分页
        Page<SampleEgg> page = new Page<>(currentPage, size);
        IPage<SampleEgg> sampleEggByPage = sampleEggMapper.getSampleEggByPage(page,sampleEgg,collectDateScope);
        RespPageBean respPageBean = new RespPageBean(sampleEggByPage.getTotal(),sampleEggByPage.getRecords());
        return respPageBean;
    }
}
