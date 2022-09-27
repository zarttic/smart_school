/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:29
 */

package com.wis.school.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wis.school.pojo.Grade;
import com.wis.school.service.GradeService;
import com.wis.school.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 级控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {
    /**
     * 级服务
     */
    @Autowired
    private GradeService gradeService;

    /**
     * 分页查年级表
     *
     * @param pageNo    页面没有
     * @param pageSize  页面大小
     * @param gradeName 年级名字
     * @return {@link Result}
     */
    @ApiOperation("查询年级信息，分页")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGradeByOpr(
            @ApiParam("查询页码数") @PathVariable(value = "pageNo") Integer pageNo,
            @ApiParam("查询页大小") @PathVariable(value = "pageSize") Integer pageSize,
            @ApiParam("模糊搜索") String gradeName) {
        Page<Grade> page = new Page<>(pageNo, pageSize);
        IPage<Grade> pages = gradeService.getGradeByOpr(page, gradeName);
        return Result.ok(pages);
    }
}
