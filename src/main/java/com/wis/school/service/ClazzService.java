/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:10
 */


package com.wis.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wis.school.pojo.Clazz;

import java.util.List;

public interface ClazzService extends IService<Clazz> {
    /**
     * 班级分页查询
     *
     * @param objectPage 对象页面
     * @param clazz      clazz
     * @return {@link IPage}<{@link Clazz}>
     */
    IPage<Clazz> getClazzsByOpr(Page<Clazz> objectPage, Clazz clazz);

    /**
     * 获取班级信息
     *
     * @return {@link List}<{@link Clazz}>
     */
    List<Clazz> getclazzs();
}
