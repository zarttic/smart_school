/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:27
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.TeacherMapper;
import com.wis.school.pojo.LoginForm;
import com.wis.school.pojo.Teacher;
import com.wis.school.service.TeacherService;
import com.wis.school.util.Encode_MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 教师服务impl
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("/teacherServiceImpl")
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link Teacher}
     */
    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", loginForm.getUsername()).eq("password", Encode_MD5.encrypt(loginForm.getPassword()));

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Teacher getTeacherById(Long userId) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Teacher> getTeachers(Page<Teacher> page, String name) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        queryWrapper.orderByDesc("id");
        queryWrapper.orderByAsc("name");

        return baseMapper.selectPage(page, queryWrapper);
    }
}
