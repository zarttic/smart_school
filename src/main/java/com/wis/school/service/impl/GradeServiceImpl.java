/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:25
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.GradeMapper;
import com.wis.school.pojo.Grade;
import com.wis.school.service.GradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 级服务impl
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("/gradeServiceImpl")
@Transactional
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

    /**
     * 年级分页查询
     *
     * @param page      页面
     * @param gradeName 年级名字
     * @return {@link IPage}<{@link Grade}>
     */
    @Override
    public IPage<Grade> getGradeByOpr(Page<Grade> page, String gradeName) {
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(gradeName)) {
            queryWrapper.like("name", gradeName);
        }
        queryWrapper.orderByDesc("id");
        queryWrapper.orderByAsc("name");

        return baseMapper.selectPage(page, queryWrapper);
    }

    /**
     * 获取年级信息
     *
     * @return {@link List}<{@link Grade}>
     */
    @Override
    public List<Grade> getGrades() {
        return baseMapper.selectList(null);
    }
}
