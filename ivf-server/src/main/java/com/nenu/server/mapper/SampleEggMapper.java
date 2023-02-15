package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.SampleEgg;
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
public interface SampleEggMapper extends BaseMapper<SampleEgg> {


    /**
     * 获取所有女性细胞信息（分页）
     * @param page
     * @param sampleEgg
     * @param collectDateScope
     * @return
     */
    IPage<SampleEgg> getSampleEggByPage(Page<SampleEgg> page,
                                       @Param("sampleEgg") SampleEgg sampleEgg,
                                       @Param("collectDateScope") LocalDateTime[] collectDateScope);
}
