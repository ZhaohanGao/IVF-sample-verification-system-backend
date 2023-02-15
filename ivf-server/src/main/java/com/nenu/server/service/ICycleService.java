package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.Cycle;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.TreatmentCase;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface ICycleService extends IService<Cycle> {

    /**
     * 获取所有周期（分页）
     * @param currentPage
     * @param size
     * @param cycle
     * @return
     */
    RespPageBean getCycleByPage(Integer currentPage, Integer size, Cycle cycle);

}
