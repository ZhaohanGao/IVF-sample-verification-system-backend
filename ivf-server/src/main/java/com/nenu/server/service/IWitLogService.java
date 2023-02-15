package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.WitLog;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface IWitLogService extends IService<WitLog> {

    /**
     * 获取所有见证日志（分页）
     * @param currentPage
     * @param size
     * @param witLog
     * @param dateTimeScope
     * @param rfid1RectimeScope
     * @param rfid2RectimeScope
     * @return
     */
    RespPageBean getWitLogByPage(Integer currentPage, Integer size, WitLog witLog, LocalDateTime[] dateTimeScope, LocalDateTime[] rfid1RectimeScope, LocalDateTime[] rfid2RectimeScope);
}
