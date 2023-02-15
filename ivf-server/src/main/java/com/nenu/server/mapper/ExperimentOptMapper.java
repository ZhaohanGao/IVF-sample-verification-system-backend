package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.ExperimentOpt;
import com.nenu.server.pojo.SampleSperm;

import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface ExperimentOptMapper extends BaseMapper<ExperimentOpt> {

    /**
     * 获取所有实验操作表项（分页）
     * @param page
     * @param experimentOpt
     * @param expDateScope
     * @return
     */
    IPage<SampleSperm> getExperimentOptByPage(Page<SampleSperm> page, ExperimentOpt experimentOpt, LocalDateTime[] expDateScope);
}
