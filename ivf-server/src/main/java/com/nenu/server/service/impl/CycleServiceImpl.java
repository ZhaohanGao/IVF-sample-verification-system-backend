package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.CycleMapper;
import com.nenu.server.pojo.Cycle;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.TreatmentCase;
import com.nenu.server.service.ICycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@Service
public class CycleServiceImpl extends ServiceImpl<CycleMapper, Cycle> implements ICycleService {

    @Autowired
    private CycleMapper cycleMapper;

    /**
     * 获取所有周期（分页）
     * @param currentPage
     * @param size
     * @param cycle
     * @return
     */
    @Override
    public RespPageBean getCycleByPage(Integer currentPage, Integer size, Cycle cycle) {
        //开启分页
        Page<Cycle> page = new Page<>(currentPage, size);
        IPage<Cycle> cycleByPage = cycleMapper.getCycleByPage(page,cycle);
        RespPageBean respPageBean = new RespPageBean(cycleByPage.getTotal(),cycleByPage.getRecords());
        return respPageBean;
    }
}
