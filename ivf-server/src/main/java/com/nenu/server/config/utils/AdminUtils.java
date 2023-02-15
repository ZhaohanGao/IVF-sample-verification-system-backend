package com.nenu.server.config.utils;

import com.nenu.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Breon
 * @description: 操作员工具类
 * @date: 2022/10/19 17:00
 */
public class AdminUtils {

    /**
     * 获取当前登录操作员
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
