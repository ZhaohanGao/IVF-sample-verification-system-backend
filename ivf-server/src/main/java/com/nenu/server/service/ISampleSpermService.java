package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleSperm;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface ISampleSpermService extends IService<SampleSperm> {

    /**
     * 获取所有男性细胞信息（分页）
     * @param currentPage
     * @param size
     * @param sampleSperm
     * @param collectDateScope
     * @return
     */
    RespPageBean getSampleSpermByPage(Integer currentPage, Integer size, SampleSperm sampleSperm, LocalDateTime[] collectDateScope);
}
