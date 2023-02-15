package com.nenu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nenu.server.pojo.Admin;
import com.nenu.server.pojo.Menu;
import com.nenu.server.pojo.RespBean;
import com.nenu.server.pojo.Role;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登录之后返回token
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     *
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据用户id查询角色列表
     *
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     *
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新操作员角色
     *
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);

    /**
     * 更新用户密码
     *
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);

    /**
     * 更新用户头像
     *
     * @param url
     * @param id
     * @param authentication
     * @return
     */
    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);

    /**
     * 添加患者信息并注册为操作员
     *
     * @param citizenId
     */
    void initPatientAdminAccount(Integer patientId, String name, String citizenId);

    /**
     * 为新添加的患者类型操作员设置密码
     *
     * @param newPass
     * @param id
     */
    void setNewAdminPassword(String newPass, Integer id);

    /**
     * 为新添加的患者类型操作员更新角色
     * @param id
     */
    void setNewAdminRole(Integer id);
}
