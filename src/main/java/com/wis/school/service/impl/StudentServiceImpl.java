/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:26
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.StudentMapper;
import com.wis.school.pojo.LoginForm;
import com.wis.school.pojo.Student;
import com.wis.school.service.StudentService;
import com.wis.school.util.Encode_MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生服务impl
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("/studentServiceImpl")
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link Student}
     */
    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", loginForm.getUsername()).eq("password", Encode_MD5.encrypt(loginForm.getPassword()));
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 通过id查询学生
     *
     * @param userId 用户id
     * @return {@link Student}
     */
    @Override
    public Student getStudentById(Long userId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 分页查询学生
     *
     * @param page 页面
     * @param name 名字
     * @return {@link IPage}<{@link Student}>
     */
    @Override
    public IPage<Student> getStudentByOpr(Page<Student> page, String name) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        queryWrapper.orderByDesc("id");
        queryWrapper.orderByAsc("name");
        return baseMapper.selectPage(page, queryWrapper);
    }
}
