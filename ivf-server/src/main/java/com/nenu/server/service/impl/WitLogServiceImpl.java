package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.mapper.SampleEggMapper;
import com.nenu.server.mapper.WitLogMapper;
import com.nenu.server.pojo.RespPageBean;
import com.nenu.server.pojo.SampleEgg;
import com.nenu.server.pojo.WitLog;
import com.nenu.server.service.IWitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@Service
public class WitLogServiceImpl extends ServiceImpl<WitLogMapper, WitLog> implements IWitLogService {

    @Autowired
    private WitLogMapper witLogMapper;

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
    @Override
    public RespPageBean getWitLogByPage(Integer currentPage, Integer size, WitLog witLog, LocalDateTime[] dateTimeScope, LocalDateTime[] rfid1RectimeScope, LocalDateTime[] rfid2RectimeScope) {
        //开启分页
        Page<WitLog> page = new Page<>(currentPage, size);
        IPage<WitLog> witLogByPage = witLogMapper.getWitLogByPage(page,witLog,dateTimeScope,rfid1RectimeScope,rfid2RectimeScope);
        RespPageBean respPageBean = new RespPageBean(witLogByPage.getTotal(),witLogByPage.getRecords());
        return respPageBean;
    }
}
