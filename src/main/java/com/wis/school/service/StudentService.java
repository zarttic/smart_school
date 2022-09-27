/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:23
 */


package com.wis.school.service;

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
    Student login(LoginForm loginForm);

    Student getStudentById(Long userId);
}
