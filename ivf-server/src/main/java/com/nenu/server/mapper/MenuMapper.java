package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nenu.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-16
 */
public interface MenuMapper extends BaseMapper<Menu> {


    /**
     * 根据角色获取菜单链表
     * @return
     */
    List<Menu> getMenusWithRole();

    List<Menu> getMenusByAdminId(Integer adminId);

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> getAllMenus();
}
