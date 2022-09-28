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
@RestController
@RequestMapping("/sms/teacherController")
public class TeacherController {
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
    @GetMapping("/getTeachers/{pageNo}/{pageSize}")
    public Result getTeachers(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            String name){
        Page<Teacher> page = new Page<>(pageNo,pageSize);
        return Result.ok(teacherService.getTeachers(page,name));
    }

    /**
     * 新增或更新老师
     *
     * @param teacher 老师
     * @return {@link Result}
     */
    @PostMapping("/saveOrUpdateTeacher")
    public Result saveOrUpdateTeacher(@RequestBody Teacher teacher){
        if (!StringUtils.isEmpty(teacher.getPassword())){
            teacher.setPassword(Encode_MD5.encrypt(teacher.getPassword()));
        }
        teacherService.saveOrUpdate(teacher);
        return Result.ok();
    }
    @DeleteMapping("deleteTeacher")
    public Result deleteTeacher(@RequestBody List<Integer> ids){
        teacherService.removeByIds(ids);
        return Result.ok();
    }

}
