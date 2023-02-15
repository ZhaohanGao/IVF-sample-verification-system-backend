package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.Cycle;
import com.nenu.server.pojo.TreatmentCase;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface CycleMapper extends BaseMapper<Cycle> {

    /**
     * 获取所有周期（分页）
     * @param page
     * @param cycle
     * @return
     */
    IPage<Cycle> getCycleByPage(Page<Cycle> page, @Param("cycle") Cycle cycle);

}
