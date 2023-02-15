package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-16
 */
public interface IMenuService extends IService<Menu> {


    /**
     * 根据角色获取菜单链表
     *
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 通过用户id查询菜单列表
     *
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> getAllMenus();
}
