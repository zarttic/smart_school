/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:29
 */

package com.wis.school.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wis.school.pojo.Teacher;
import com.wis.school.service.TeacherService;
import com.wis.school.util.Encode_MD5;
import com.wis.school.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 老师控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Api(tags = "教师控制器")
@RestController
@RequestMapping("/sms/teacherController")
public class TeacherController {
    /**
     * 教师服务接口
     */
    @Autowired
    private TeacherService teacherService;

    /**
     * 获取到老师信息
     *
     * @param pageNo   页面编号
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link Result}
     */
    @ApiOperation("分页查询教师")
    @GetMapping("/getTeachers/{pageNo}/{pageSize}")
    public Result getTeachers(
            @ApiParam("查询的页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("查询的页大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("进行模糊查询的参数") String name) {
        Page<Teacher> page = new Page<>(pageNo, pageSize);
        return Result.ok(teacherService.getTeachers(page, name));
    }

    /**
     * 新增或更新老师
     *
     * @param teacher 老师
     * @return {@link Result}
     */
    @ApiOperation("更新教师信息或新增教师")
    @PostMapping("/saveOrUpdateTeacher")
    public Result saveOrUpdateTeacher(@ApiParam("修改或新增的教师对象") @RequestBody Teacher teacher) {
        if (!StringUtils.isEmpty(teacher.getPassword())) {
            teacher.setPassword(Encode_MD5.encrypt(teacher.getPassword()));
        }
        teacherService.saveOrUpdate(teacher);
        return Result.ok();
    }

    @ApiOperation("删除教师")
    @DeleteMapping("deleteTeacher")
    public Result deleteTeacher(@ApiParam("删除的教师id集合") @RequestBody List<Integer> ids) {
        teacherService.removeByIds(ids);
        return Result.ok();
    }

}
