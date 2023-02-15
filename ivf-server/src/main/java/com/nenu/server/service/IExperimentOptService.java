package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.ExperimentOpt;
import com.nenu.server.pojo.RespPageBean;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface IExperimentOptService extends IService<ExperimentOpt> {

    /**
     * 获取所有实验操作表项（分页）
     * @param currentPage
     * @param size
     * @param experimentOpt
     * @param expDateScope
     * @return
     */
    RespPageBean getExperimentOptByPage(Integer currentPage, Integer size, ExperimentOpt experimentOpt, LocalDateTime[] expDateScope);
}
