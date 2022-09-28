/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:23
 */


package com.wis.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wis.school.pojo.LoginForm;
import com.wis.school.pojo.Teacher;

/**
 * 教师服务
 *
 * @author liyaj
 * @date 2022/09/27
 */
public interface TeacherService extends IService<Teacher> {
    Teacher login(LoginForm loginForm);

     Teacher getTeacherById(Long userId);

    IPage<Teacher> getTeachers(Page<Teacher> page, String name);
}
