package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;

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
public interface ISampleEggService extends IService<SampleEgg> {

    /**
     * 获取所有女性细胞信息（分页）
     * @param currentPage
     * @param size
     * @param sampleEgg
     * @param collectDateScope
     * @return
     */
    RespPageBean getSampleEggByPage(Integer currentPage, Integer size, SampleEgg sampleEgg, LocalDateTime[] collectDateScope);
}
