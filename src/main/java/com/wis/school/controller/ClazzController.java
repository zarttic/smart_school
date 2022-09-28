/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:29
 */

package com.wis.school.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wis.school.pojo.Clazz;
import com.wis.school.service.ClazzService;
import com.wis.school.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * clazz控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Api(tags = "班级管理器")
@RestController
@RequestMapping("/sms/clazzController")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /**
     * 班级分页查询
     *
     * @param pageNo   页面没有
     * @param pageSize 页面大小
     * @param clazz    班级信息
     * @return {@link Result}
     */
    @ApiOperation("查询班级信息,分页带条件")
    @GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
    public Result getClazzsByOpr(
            @ApiParam("查询页数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("页面大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("模糊查询") Clazz clazz) {
        IPage<Clazz> iPage = clazzService.getClazzsByOpr(new Page<Clazz>(pageNo, pageSize), clazz);
        return Result.ok(iPage);
    }

    /**
     * 保存或更新班级信息
     *
     * @param clazz 修改的班级对象
     * @return {@link Result}
     */
    @ApiOperation("修改/新建班级")
    @PostMapping("/saveOrUpdateClazz")
    public Result saveOrUpdateClazz(
            @ApiParam("修改的对象") @RequestBody Clazz clazz) {
        clazzService.saveOrUpdate(clazz);
        return Result.ok();
    }

    @ApiOperation("删除操作")
    @DeleteMapping("/deleteClazz")
    public Result deleteClazz(
            @ApiParam("删除的对象") @RequestBody List<Integer> ids) {
        clazzService.removeBatchByIds(ids);
        return Result.ok();
    }

    @ApiOperation("获取所有班级")
    @GetMapping("/getClazzs")
    public Result getclazzs() {
        return Result.ok(clazzService.getclazzs());
    }


}
