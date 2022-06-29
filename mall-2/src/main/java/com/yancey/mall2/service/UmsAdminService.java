package com.yancey.mall2.service;

import com.yancey.mall2.mbg.model.UmsAdmin;
import com.yancey.mall2.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员Service
 */
public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     *
     * @param username
     * @param password
     * @return 生成的 JWT token
     */
    String login(String username, String password);

    /**
     * 获取用户权限，包括+-权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
