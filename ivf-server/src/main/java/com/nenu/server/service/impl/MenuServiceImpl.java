package com.nenu.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nenu.server.config.utils.AdminUtils;
import com.nenu.server.mapper.MenuMapper;
import com.nenu.server.pojo.Menu;
import com.nenu.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Breon
 * @since 2022-10-16
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 根据角色获取菜单链表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

//    /**
//     * 通过用户id查询菜单列表
//     * @return
//     */
//    @Override
//    public List<Menu> getMenusByAdminId() {
//        Integer adminId = AdminUtils.getCurrentAdmin().getId();
//        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//        //从redis获取菜单数据
//        List<Menu> menus = ((List<Menu>)valueOperations.get("menu_"+adminId));
//        //如果为空从数据库获取
//        if (CollectionUtils.isEmpty(menus)){
//            menus = menuMapper.getMenusByAdminId(adminId);
//            //将数据设置到redis中
//            valueOperations.set("menu_"+adminId,menus);
//        }
//        return menus;
//    }
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        return menuMapper.getMenusByAdminId(adminId);
    }

    /**
     * 查询所有菜单
     *
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
