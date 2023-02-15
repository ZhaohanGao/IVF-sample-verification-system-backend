package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.pojo.WitLog;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface WitLogMapper extends BaseMapper<WitLog> {

    /**
     * 获取所有见证日志（分页）
     * @param page
     * @param witLog
     * @param dateTimeScope
     * @param rfid1RectimeScope
     * @param rfid2RectimeScope
     * @return
     */
    IPage<WitLog> getWitLogByPage(Page<WitLog> page,
                                  @Param("witLog") WitLog witLog,
                                  @Param("dateTimeScope") LocalDateTime[] dateTimeScope,
                                  @Param("rfid1RectimeScope") LocalDateTime[] rfid1RectimeScope,
                                  @Param("rfid2RectimeScope") LocalDateTime[] rfid2RectimeScope);
}
