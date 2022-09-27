/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:05
 */


package com.wis.school.service;

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

    Admin login(LoginForm loginForm);

    Admin getAdminById(Long userId);
}
