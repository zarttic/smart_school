/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:24
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.ClazzMapper;
import com.wis.school.pojo.Clazz;
import com.wis.school.service.ClazzService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * impl clazz服务
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("clazzServiceImpl")
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
    @Override
    public IPage<Clazz> getClazzsByOpr(Page<Clazz> pageParam, Clazz clazz) {
        QueryWrapper<Clazz> queryWrapper = new QueryWrapper<>();
        if (clazz != null) {
            String gradeName = clazz.getGradeName();
            if (!StringUtils.isEmpty(gradeName)) {
                queryWrapper.eq("grade_name", gradeName);
            }
            String clazzName = clazz.getName();
            if (!StringUtils.isEmpty(clazzName)) {
                queryWrapper.like("name", clazzName);
            }
            queryWrapper.orderByDesc("id");
            queryWrapper.orderByAsc("name");
        }
        return baseMapper.selectPage(pageParam, queryWrapper);
    }

    /**
     * 获取班级信息
     *
     * @return {@link List}<{@link Clazz}>
     */
    @Override
    public List<Clazz> getclazzs() {
        return baseMapper.selectList(null);
    }
}
