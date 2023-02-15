package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.SampleSperm;
import com.nenu.server.pojo.TreatmentCase;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface SampleSpermMapper extends BaseMapper<SampleSperm> {

    /**
     * 获取所有男性细胞信息（分页）
     * @param page
     * @param sampleSperm
     * @param collectDateScope
     * @return
     */
    IPage<SampleSperm> getSampleSpermByPage(Page<SampleSperm> page,
                                                @Param("sampleSperm") SampleSperm sampleSperm,
                                                @Param("collectDateScope") LocalDateTime[] collectDateScope);

}
