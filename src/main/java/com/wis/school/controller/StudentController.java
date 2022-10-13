/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:29
 */

package com.wis.school.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wis.school.pojo.Student;
import com.wis.school.service.StudentService;
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
 * 学生控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Api(tags = "学生控制器")
@RestController
@RequestMapping("/sms/studentController")
public class StudentController {
    /**
     * 学生服务
     */
    @Autowired
    private StudentService studentService;

    /**
     * 分页查询学生信息
     *
     * @param pageNo   页面没有
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link Result}
     */
    @ApiOperation("分页查询学生信息")
    @GetMapping("/getStudentByOpr/{pageNo}/{pageSize}")
    public Result getStudentByOpr(
            @ApiParam("查询页码") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("页面大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("姓名模糊查询") String name) {
        Page<Student> page = new Page<>(pageNo, pageSize);
        return Result.ok(studentService.getStudentByOpr(page, name));
    }

    /**
     * 添加或更新学生
     *
     * @param student 学生
     * @return {@link Result}
     */
    @ApiOperation("修改学生信息")
    @PostMapping("/addOrUpdateStudent")
    public Result addOrUpdateStudent(
            @ApiParam("修改学生对象") @RequestBody Student student) {
        if (!StringUtils.isEmpty(student.getPassword())) {
            student.setPassword(Encode_MD5.encrypt(student.getPassword()));
        }
        studentService.saveOrUpdate(student);
        return Result.ok();
    }

    /**
     * 通过id删除学生
     *
     * @param ids id
     * @return {@link Result}
     */
    @DeleteMapping("delStudentById")
    public Result delStudentById(@RequestBody List<Integer> ids) {
        studentService.removeByIds(ids);
        return Result.ok();
    }


}
