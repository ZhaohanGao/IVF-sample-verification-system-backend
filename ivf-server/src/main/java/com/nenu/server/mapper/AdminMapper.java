package com.nenu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nenu.server.pojo.Admin;
import com.nenu.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);

    List<Menu> getMenusByAdminId(Integer id);

    void initPatientAdminAccount(@Param("patientId") Integer patientId,
                                 @Param("name") String name,
                                 @Param("citizenId") String citizenId);

    void initPatientBirthdayAndGender(@Param("patientId") Integer patientId,
                                    @Param("citizenId") String citizenId);
}
