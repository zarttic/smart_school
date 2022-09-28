/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:06
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.AdminMapper;
import com.wis.school.pojo.Admin;
import com.wis.school.pojo.LoginForm;
import com.wis.school.service.AdminService;
import com.wis.school.util.Encode_MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理服务接口实现
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("/adminServiceImpl") //实现id
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService {
    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link Admin}
     */
    @Override
    public Admin login(LoginForm loginForm) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", loginForm.getUsername()).eq("password", Encode_MD5.encrypt(loginForm.getPassword()));
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 通过id获取管理员
     *
     * @param userId 用户id
     * @return {@link Admin}
     */
    @Override
    public Admin getAdminById(Long userId) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 查询到所有的管理
     *
     * @param page 页面
     * @param name 名字
     * @return {@link IPage}<{@link Admin}>
     */
    @Override
    public IPage<Admin> getAllAdmin(Page<Admin> page, String name) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        return baseMapper.selectPage(page, queryWrapper);
    }
}
