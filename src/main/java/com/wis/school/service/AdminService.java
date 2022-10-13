/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:05
 */


package com.wis.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wis.school.pojo.Admin;
import com.wis.school.pojo.LoginForm;

/**
 * 管理服务
 *
 * @author liyaj
 * @date 2022/09/27
 */
public interface AdminService extends IService<Admin> {

    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link Admin}
     */
    Admin login(LoginForm loginForm);

    /**
     * 通过id获取管理
     *
     * @param userId 用户id
     * @return {@link Admin}
     */
    Admin getAdminById(Long userId);

    /**
     * 得到所有管理
     *
     * @param page 页面
     * @param name 名字
     * @return {@link IPage}<{@link Admin}>
     */
    IPage<Admin> getAllAdmin(Page<Admin> page, String name);
}
