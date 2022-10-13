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
    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link Teacher}
     */
    Teacher login(LoginForm loginForm);

    /**
     * 通过id获取老师
     *
     * @param userId 用户id
     * @return {@link Teacher}
     */
    Teacher getTeacherById(Long userId);

    /**
     * 得到老师
     *
     * @param page 页面
     * @param name 名字
     * @return {@link IPage}<{@link Teacher}>
     */
    IPage<Teacher> getTeachers(Page<Teacher> page, String name);
}
