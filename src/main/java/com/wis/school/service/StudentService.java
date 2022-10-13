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
import com.wis.school.pojo.Student;

/**
 * 学生服务
 *
 * @author liyaj
 * @date 2022/09/27
 */
public interface StudentService extends IService<Student> {
    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link Student}
     */
    Student login(LoginForm loginForm);

    /**
     * 让学生通过id
     *
     * @param userId 用户id
     * @return {@link Student}
     */
    Student getStudentById(Long userId);

    /**
     * 被超载比学生
     *
     * @param page 页面
     * @param name 名字
     * @return {@link IPage}<{@link Student}>
     */
    IPage<Student> getStudentByOpr(Page<Student> page, String name);
}
