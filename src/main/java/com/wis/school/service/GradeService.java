/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:23
 */


package com.wis.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wis.school.pojo.Grade;

import java.util.List;

/**
 * 年级服务
 *
 * @author liyaj
 * @date 2022/09/27
 */
public interface GradeService extends IService<Grade> {
    /**
     * 年级分页查询
     *
     * @param page      页面
     * @param gradeName 年级名字
     * @return {@link IPage}<{@link Grade}>
     */
    IPage<Grade> getGradeByOpr(Page<Grade> page, String gradeName);

    /**
     * 得到年级
     *
     * @return {@link List}<{@link Grade}>
     */
    List<Grade> getGrades();
}
